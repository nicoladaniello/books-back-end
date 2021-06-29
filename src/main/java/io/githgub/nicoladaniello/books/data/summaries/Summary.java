package io.githgub.nicoladaniello.books.data.summaries;

import io.githgub.nicoladaniello.books.data.GenericEntity;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Synchronize;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name = "SupplierSummary")
@Synchronize({"Supplier", "Invoice", "Payment"})
@Immutable
public class Summary implements GenericEntity {

    @Column(name = "supplier_id")
    @Id
    private long id;
    @Column(name = "period_id")
    private long periodId;
    @Column(name = "supplier_name")
    private String supplierName;
    @Column(name = "total_due_amount")
    private BigDecimal totalDueAmount;
    @Column(name = "total_paid_amount")
    private BigDecimal totalPaidAmount;
    @Transient
    private BigDecimal outstandingAmount;

    public Summary() { }

    @Override
    public String toString() {
        return "SupplierSummary{" +
                "supplierId=" + id +
                ", supplierName=" + supplierName +
                ", totalDueAmount=" + totalDueAmount +
                ", totalPaidAmount=" + totalPaidAmount +
                ", leftoverAmount=" + outstandingAmount +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPeriodId() {
        return periodId;
    }

    public void setPeriodId(long periodId) {
        this.periodId = periodId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
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
        return (totalDueAmount == null || totalPaidAmount == null) ?
                BigDecimal.ZERO :
                totalDueAmount.subtract(totalPaidAmount);
    }

    public void setOutstandingAmount(BigDecimal outstandingAmount) {
        this.outstandingAmount = outstandingAmount;
    }
}
