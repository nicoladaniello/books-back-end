package io.githgub.nicoladaniello.books.configs;

import io.githgub.nicoladaniello.books.data.companies.CompanyRepository;
import org.flywaydb.core.Flyway;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Flyway configuration for multi-tenancy schema migrations.
 * We configure it to start migrations for the default schema from the db/migration/default directory,
 * and then iterate over all tenants and start migrations for each of them from the db/migration/tenants directory.
 *
 * https://sultanov.dev/blog/schema-based-multi-tenancy-with-spring-data/
 */
@Configuration
public class FlywayConfig {

    @Bean
    public Flyway flyway(DataSource dataSource) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/default")
                .dataSource(dataSource)
                .schemas(TenantIdentifierResolver.DEFAULT_TENANT)
                .load();
        flyway.migrate();
        return flyway;
    }

    @Bean
    CommandLineRunner commandLineRunner(CompanyRepository repository, DataSource dataSource) {
        return args -> {
            repository.findAll().forEach(company -> {
                String tenant = company.getName();
                Flyway flyway = Flyway.configure()
                        .locations("db/migration/tenants")
                        .dataSource(dataSource)
                        .schemas(tenant)
                        .load();
                flyway.migrate();
            });
        };
    }
}