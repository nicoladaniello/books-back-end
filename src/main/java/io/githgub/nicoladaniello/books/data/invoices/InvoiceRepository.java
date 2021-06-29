package io.githgub.nicoladaniello.books.data.invoices;

import io.githgub.nicoladaniello.books.data.BaseRepository;
import io.githgub.nicoladaniello.books.data.periods.Period;
import io.githgub.nicoladaniello.books.data.suppliers.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvoiceRepository extends BaseRepository<Invoice, Long> {

    List<Invoice> findByDescriptionContainingIgnoreCase(String description);

    List<Invoice> findBySupplierAndDescriptionContainingIgnoreCase(Supplier supplier, String description);

    Page<Invoice> findAllBySupplier(@Param("supplier") Supplier supplier, Pageable page);

    // Find all Invoices which date is within a Period or
    // which date is before the Period but the total paid amount is less then the invoice amount.
    @Query("FROM Invoice i WHERE " +
            "(i.dated >= :#{#period.startDate} AND i.dated <= :#{#period.endDate}) " +
            "OR (i.dated < :#{#period.startDate} AND i.totalPaidAmount < i.amount)")
    Page<Invoice> findAllByPeriod(@Param("period") Period period, Pageable page);

    // Like findAllByPeriod but filtered by supplier.
    @Query("FROM Invoice i WHERE i.supplier = :supplier " +
            "AND ((i.dated >= :#{#period.startDate} AND i.dated <= :#{#period.endDate}) " +
            "OR (i.dated < :#{#period.startDate} AND i.totalPaidAmount < i.amount))")
    Page<Invoice> findAllBySupplierAndPeriod(
            @Param("supplier") Supplier supplier,
            @Param("period") Period period,
            Pageable page
    );
}
