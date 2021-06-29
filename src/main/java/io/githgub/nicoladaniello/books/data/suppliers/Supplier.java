package io.githgub.nicoladaniello.books.data.suppliers;

import io.githgub.nicoladaniello.books.data.BaseEntity;
import io.githgub.nicoladaniello.books.data.invoices.Invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@SequenceGenerator(name = "default_gen", sequenceName = "suppliers_sequence", allocationSize = 10)
public class Supplier extends BaseEntity {

    @NotNull
    @Size(min=3)
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "supplier", orphanRemoval = true, cascade = CascadeType.PERSIST)
    private List<Invoice> invoices;

    @Column(name = "vat_number")
    private String vatNumber;

    @Column(name = "tax_code")
    private String taxCode;

    private String address;
    private String email;
    private String phone;

    public Supplier() {
    }

    public Supplier(
            String name,
            String vatNumber,
            String address,
            String taxCode,
            String email,
            String phone
    ) {
        this.name = name;
        this.vatNumber = vatNumber;
        this.address = address;
        this.taxCode = taxCode;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return id == supplier.id && name.equals(supplier.name);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", invoices=" + invoices +
                ", vatNumber='" + vatNumber + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", created=" + created +
                ", modified=" + modified +
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

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}