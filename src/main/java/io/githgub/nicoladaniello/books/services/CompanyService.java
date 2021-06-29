package io.githgub.nicoladaniello.books.services;

import io.githgub.nicoladaniello.books.data.companies.Company;
import io.githgub.nicoladaniello.books.data.companies.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements UserDetailsService {
    private final CompanyRepository repository;
    private final TenantService tenantService;
    private final PasswordEncoder encoder;

    public CompanyService(CompanyRepository repository, TenantService tenantService) {
        this.repository = repository;
        this.tenantService = tenantService;
        this.encoder = new BCryptPasswordEncoder();
    }

    public List<Company> getCompanies() {
        return repository.findAll();
    }

    public Company create(Company company) {
        String encodedPassword = encoder.encode(company.getPassword());
        company.setPassword(encodedPassword);
        tenantService.initDatabase(company.getName());
        return repository.save(company);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("Company not found."));
    }
}
