package io.githgub.nicoladaniello.books.data.payments;

import com.sun.istack.NotNull;
import io.githgub.nicoladaniello.books.data.invoices.Invoice;
import io.githgub.nicoladaniello.books.data.transactions.Transaction;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "default_gen", sequenceName = "transactions_sequence", allocationSize = 10)
public class Payment extends Transaction {

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @Formula("(SELECT i.description FROM invoice i WHERE i.id = invoice_id)")
    private String invoiceDescription;

    // Get this payment's invoice leftover to pay after this payment was made.
    @Formula(
            "(SELECT (i.amount - SUM(p.amount)) FROM invoice i INNER JOIN payment p ON p.invoice_id = i.id " +
                    "WHERE i.id = invoice_id AND p.dated <= dated)"
    )
    private BigDecimal leftoverToDate;

    public Payment() { }

    public Payment(Invoice invoice, LocalDate date, String description, BigDecimal amount) {
        super(date, description, amount);
        this.invoice = invoice;
    }

    /*
     * Getters & Setters
     */

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public String getInvoiceDescription() {
        return invoiceDescription;
    }

    public void setInvoiceDescription(String invoiceDescription) {
        this.invoiceDescription = invoiceDescription;
    }

    public BigDecimal getLeftoverToDate() {
        return leftoverToDate;
    }

    public void setLeftoverToDate(BigDecimal leftoverToDate) {
        this.leftoverToDate = leftoverToDate;
    }
}
