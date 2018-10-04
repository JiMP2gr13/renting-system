package com.skteam.rentingsystem.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "rent-item")
public class RentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @Column(name = "rental_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date rentalDate;

    @Column(name = "return_date", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date returnDate;

    @Column(name = "returned")
    private boolean returned;

    public RentDetails() {
    }

    public RentDetails(Item item, User customer, Date rentalDate, Date returnDate, boolean returned) {
        this.item = item;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.returned = returned;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public java.util.Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    public java.util.Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    @Override
    public String toString() {
        return "RentItem{" +
                "id=" + id +
                ", item=" + item +
                ", customer=" + customer +
                ", rentalDate=" + rentalDate +
                ", returnDate=" + returnDate +
                ", returned=" + returned +
                '}';
    }
}
