package io.githgub.nicoladaniello.books.data.invoices;

import com.sun.istack.NotNull;
import io.githgub.nicoladaniello.books.data.payments.Payment;
import io.githgub.nicoladaniello.books.data.suppliers.Supplier;
import io.githgub.nicoladaniello.books.data.transactions.Transaction;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "default_gen", sequenceName = "transactions_sequence", allocationSize = 10)
public class Invoice extends Transaction {

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Formula("(SELECT s.name FROM supplier s WHERE s.id = supplier_id)")
    private String supplierName;

    @Formula("(SELECT IFNULL(SUM(p.amount), 0) FROM Payment p WHERE p.invoice_id = id)")
    private BigDecimal totalPaidAmount;

    @Formula("(SELECT amount - IFNULL(SUM(p.amount), 0) FROM payment p WHERE p.invoice_id = id)")
    private BigDecimal leftoverAmount;

    @OneToMany(mappedBy = "invoice", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Payment> payments;

    public Invoice() {
    }

    public Invoice(Supplier supplier, LocalDate date, String description, BigDecimal amount) {
        super(date, description, amount);
        this.supplier = supplier;
    }

    /*
     * Getters & Setters
     */

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(BigDecimal totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public BigDecimal getLeftoverAmount() {
        return leftoverAmount;
    }

    public void setLeftoverAmount(BigDecimal leftoverAmount) {
        this.leftoverAmount = leftoverAmount;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
