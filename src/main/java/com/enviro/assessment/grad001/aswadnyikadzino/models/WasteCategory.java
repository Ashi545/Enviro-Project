package com.enviro.assessment.grad001.aswadnyikadzino.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class WasteCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WasteCategory(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public WasteCategory() {
    }
}
