package io.githgub.nicoladaniello.books.services;

import org.flywaydb.core.Flyway;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * Create a service for programmatically creating a scheme for new tenants
 * and performing all relevant migration.
 *
 * https://sultanov.dev/blog/schema-based-multi-tenancy-with-spring-data/
 */
@Service
public class TenantService {

    private final DataSource dataSource;

    public TenantService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void initDatabase(String schema) {
        Flyway flyway = Flyway.configure()
                .locations("db/migration/tenants")
                .dataSource(dataSource)
                .schemas(schema)
                .load();
        flyway.migrate();
    }
}