package io.githgub.nicoladaniello.books.configs;

import io.githgub.nicoladaniello.books.data.companies.Company;
import io.githgub.nicoladaniello.books.data.invoices.Invoice;
import io.githgub.nicoladaniello.books.data.payments.Payment;
import io.githgub.nicoladaniello.books.data.periods.Period;
import io.githgub.nicoladaniello.books.data.summaries.Summary;
import io.githgub.nicoladaniello.books.data.suppliers.Supplier;
import io.githgub.nicoladaniello.books.data.transactions.Transaction;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Company.class, Period.class, Supplier.class, Summary.class, Invoice.class, Payment.class);
    }
}
