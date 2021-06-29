package io.githgub.nicoladaniello.books.security;

import io.githgub.nicoladaniello.books.utils.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static io.githgub.nicoladaniello.books.security.SecurityConstants.HEADER_STRING;
import static io.githgub.nicoladaniello.books.security.SecurityConstants.TOKEN_PREFIX;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws ServletException, IOException {

        try {
            final String requestTokenHeader = request.getHeader(HEADER_STRING);

            if (requestTokenHeader == null || !requestTokenHeader.startsWith(TOKEN_PREFIX)) {
                throw new IllegalArgumentException();
            }

            String jwtToken = requestTokenHeader.replace(TOKEN_PREFIX, "");
            String username = JwtTokenUtil.getUsername(jwtToken);

            if (!JwtTokenUtil.validate(jwtToken) ||
                    username == null ||
                    SecurityContextHolder.getContext().getAuthentication() != null
            ) {
                throw new IllegalArgumentException();
            }

            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                    new UsernamePasswordAuthenticationToken(
                            username,
                            null,
                            Collections.emptyList()
                    );

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

        } catch (IllegalArgumentException e) {
            LoggerFactory.getLogger(getFilterName()).error("Invalid token.");
        } catch (ExpiredJwtException e) {
            LoggerFactory.getLogger(getFilterName()).error("The JWT token is expired.");
        }

        chain.doFilter(request, response);
    }
}
