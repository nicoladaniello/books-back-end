package io.githgub.nicoladaniello.books.data.summaries;

import io.githgub.nicoladaniello.books.data.BaseRepository;
import io.githgub.nicoladaniello.books.data.periods.Period;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface SummaryRepository extends BaseRepository<Summary, Long> {
    @Query("FROM SupplierSummary s WHERE period_id = :#{#period.id}")
    Page<Summary> findAllByPeriod(@Param("period") Period period, Pageable page);
}
