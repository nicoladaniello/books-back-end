package io.githgub.nicoladaniello.books.data.periods;

import io.githgub.nicoladaniello.books.data.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface PeriodRepository
        extends BaseRepository<Period, Long>, JpaSpecificationExecutor<Period> {
    Optional<Period> findByName(String name);

    List<Period> findByNameContainingIgnoreCase(String name);
}
