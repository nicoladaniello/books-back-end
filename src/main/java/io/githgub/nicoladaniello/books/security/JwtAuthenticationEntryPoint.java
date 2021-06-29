package io.githgub.nicoladaniello.books.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.githgub.nicoladaniello.books.exceptions.ApiError;
import io.githgub.nicoladaniello.books.utils.Messages;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    Messages messages;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException, ServletException {
        LoggerFactory.getLogger(getClass().getName()).error(authException.toString());

        HttpStatus status = HttpStatus.FORBIDDEN;
        String message = messages.get("security.errors.accessDenied");

        if (authException instanceof BadCredentialsException) {
            status = HttpStatus.UNAUTHORIZED;
            message = messages.get("security.errors.BadCredentials");
        }

        ApiError apiError = new ApiError(status, message);

        ResponseEntity<Object> responseEntity =
                new ResponseEntity<>(apiError, new HttpHeaders(), apiError.getStatus());

        response.setStatus(responseEntity.getStatusCodeValue());

        String body = new ObjectMapper().writeValueAsString(responseEntity.getBody());
        response.getWriter().write(body);
        response.flushBuffer();
    }
}