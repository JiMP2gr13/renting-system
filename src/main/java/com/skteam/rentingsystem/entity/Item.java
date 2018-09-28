package com.skteam.rentingsystem.entity;

import javax.persistence.*;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "photo_path")
    private String photoPath;

    @Column(name = "details")
    private String details;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @Column(name = "cost_per_day")
    private Double costPerDay;

    public Item() {
    }

    public Item(String name, Category category, String photoPath, String details, User owner, Double costPerDay) {
        this.name = name;
        this.category = category;
        this.photoPath = photoPath;
        this.details = details;
        this.owner = owner;
        this.costPerDay = costPerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Double getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Double costPerDay) {
        this.costPerDay = costPerDay;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", photoPath='" + photoPath + '\'' +
                ", details='" + details + '\'' +
                ", owner=" + owner +
                ", costPerDay=" + costPerDay +
                '}';
    }
}
