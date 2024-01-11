package org.example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class AnEntity {
    @Id
    private int id;
    private String name;
    private double quantity;

    // Constructors
    public AnEntity() {}

    public AnEntity(int id, String name, double quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and setters
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

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
