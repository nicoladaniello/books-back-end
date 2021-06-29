package io.githgub.nicoladaniello.books.data.payments;

import io.githgub.nicoladaniello.books.data.BaseRepository;
import io.githgub.nicoladaniello.books.data.invoices.Invoice;
import io.githgub.nicoladaniello.books.data.periods.Period;
import io.githgub.nicoladaniello.books.data.suppliers.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends BaseRepository<Payment, Long> {

    List<Payment> findByDescriptionContainingIgnoreCase(String description);

    Page<Payment> findAllByInvoice(Invoice invoice, Pageable page);

    @Query("SELECT p FROM Payment p INNER JOIN p.invoice i WHERE i.supplier = :supplier")
    Page<Payment> findAllBySupplier(@Param("supplier") Supplier supplier, Pageable page);

    // Find all Payments which date is within a given Period.
    @Query("FROM Payment p WHERE " +
            "p.dated >= :#{#period.startDate} " +
            "AND p.dated <= :#{#period.endDate}"
    )
    Page<Payment> findAllByPeriod(@Param("period") Period period, Pageable page);

    @Query("SELECT p FROM Payment p INNER JOIN p.invoice i WHERE " +
            "i.supplier = :supplier " +
            "AND p.dated >= :#{#period.startDate} " +
            "AND p.dated <= :#{#period.endDate}"
    )
    Page<Payment> findAllByPeriodAndSupplier(
            @Param("supplier") Supplier supplier,
            @Param("period") Period period,
            Pageable page
    );

    @Query("SELECT p FROM Payment p INNER JOIN p.invoice i WHERE " +
            "p.invoice = :invoice " +
            "AND p.dated >= :#{#period.startDate} " +
            "AND p.dated <= :#{#period.endDate}"
    )
    Page<Payment> findAllByPeriodAndInvoice(
            @Param("period") Period period,
            @Param("invoice") Invoice invoice,
            Pageable page
    );
}
