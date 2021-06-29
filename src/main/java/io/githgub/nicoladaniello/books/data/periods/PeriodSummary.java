package io.githgub.nicoladaniello.books.data.periods;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Synchronize;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Synchronize({"Period", "Invoice", "Payment"})
@Immutable
public class PeriodSummary {

    @Column
    @Id
    private long id;
    @Column(name = "total_due_amount")
    private BigDecimal totalDueAmount;
    @Column(name = "total_paid_amount")
    private BigDecimal totalPaidAmount;
    @Column(name = "outstanding_amount")
    private BigDecimal outstandingAmount;

    public PeriodSummary() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getTotalDueAmount() {
        return totalDueAmount;
    }

    public void setTotalDueAmount(BigDecimal totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }

    public BigDecimal getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(BigDecimal totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public BigDecimal getOutstandingAmount() {
        return outstandingAmount;
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
