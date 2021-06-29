package io.githgub.nicoladaniello.books;

import io.githgub.nicoladaniello.books.data.BaseRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("io.githgub.nicoladaniello.books.data")
@EnableJpaRepositories(value = "io.githgub.nicoladaniello.books.data", repositoryBaseClass = BaseRepositoryImpl.class)
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

}
