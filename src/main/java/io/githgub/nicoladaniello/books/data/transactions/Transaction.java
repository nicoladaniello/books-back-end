package io.githgub.nicoladaniello.books.data.transactions;

import com.sun.istack.NotNull;
import io.githgub.nicoladaniello.books.data.BaseEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@MappedSuperclass
public abstract class Transaction extends BaseEntity {

    @NotNull
    protected LocalDate dated;

    @NotNull
    protected String description;

    @NotNull
    protected BigDecimal amount;

    public Transaction() {
    }

    public Transaction(LocalDate dated, String description, BigDecimal amount) {
        this.dated = dated;
        this.description = description;
        this.amount = amount;
    }

    @PrePersist
    protected void onPrePersist() {
        created = LocalDate.now();
    }

    @PreUpdate
    protected void onPreUpdate() {
        modified = LocalDate.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                Objects.equals(dated, that.dated) &&
                Objects.equals(description, that.description) &&
                Objects.equals(amount, that.amount);
    }

    /*
     * Getters & Setters
     */

    public LocalDate getDated() {
        return dated;
    }

    public void setDated(LocalDate dated) {
        this.dated = dated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
