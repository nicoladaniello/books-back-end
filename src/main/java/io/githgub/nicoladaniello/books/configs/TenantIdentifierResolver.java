package io.githgub.nicoladaniello.books.configs;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Principal;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * Using Hibernate Multi-tenancy feature.
 * Use CurrentTenantIdentifierResolver to resolve the tenant identifier to use.
 * Gets the authentication data from the security context and uses the username as the identifier of the tenant;
 * if authentication is anonymous or missing, it falls back to the default tenant identifier.
 *
 * https://sultanov.dev/blog/schema-based-multi-tenancy-with-spring-data/
 */
@Component
public class TenantIdentifierResolver implements CurrentTenantIdentifierResolver {

    static final String DEFAULT_TENANT = "default";

    @Override
    public String resolveCurrentTenantIdentifier() {
        return Optional
                .ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .filter(Predicate.not(authentication -> authentication instanceof AnonymousAuthenticationToken))
                .map(Principal::getName)
                .orElse(DEFAULT_TENANT);
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
