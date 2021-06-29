package io.githgub.nicoladaniello.books.data.periods;

import io.githgub.nicoladaniello.books.data.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "periods_sequence", allocationSize = 10)
@Table(name = "period")
public class Period extends BaseEntity {

    @NotNull
    @Size(min=3)
    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @OneToOne(fetch = FetchType.EAGER)
    @PrimaryKeyJoinColumn
    private PeriodSummary summary;

    public Period() { }

    public Period(String name, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Period period = (Period) o;
        return id == period.id &&
                Objects.equals(name, period.name) &&
                startDate.equals(period.startDate) &&
                endDate.equals(period.endDate);
    }

    @Override
    public String toString() {
        return "Period{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }

    /*
     * Getters & Setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PeriodSummary getSummary() {
        return summary;
    }

    public void setSummary(PeriodSummary summary) {
        this.summary = summary;
    }
}
