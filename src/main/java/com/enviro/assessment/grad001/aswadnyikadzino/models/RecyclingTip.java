package com.enviro.assessment.grad001.aswadnyikadzino.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Recycle")
public class RecyclingTip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String tip;

    public RecyclingTip(long id, String recycleTip) {
        this.id = id;
        this.tip = recycleTip;
    }

    public RecyclingTip() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public long getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    @Override
    public String toString() {
        return "Recycling{" +
                "id=" + id +
                ", recycleTip='" + tip + '\'' +
                '}';
    }
}
