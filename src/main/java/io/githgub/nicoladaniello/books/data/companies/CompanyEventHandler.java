package io.githgub.nicoladaniello.books.data.companies;

import io.githgub.nicoladaniello.books.services.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RepositoryEventHandler
public class CompanyEventHandler {
    private final TenantService tenantService;
    private final PasswordEncoder encoder;

    @Autowired
    public CompanyEventHandler(TenantService tenantService) {
        this.tenantService = tenantService;
        this.encoder = new BCryptPasswordEncoder();
    }

    @HandleBeforeCreate
    public void onBeforeCreate(Company company) {
        String encodedPassword = encoder.encode(company.getPassword());
        company.setPassword(encodedPassword);
        tenantService.initDatabase(company.getName());
    }
}
