package com.enviro.assessment.grad001.aswadnyikadzino.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Guideline")
public class DisposalGuideline {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String guideline;

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DisposalGuideline(long id, String guideline) {
        this.id = id;
        this.guideline = guideline;
    }

    public DisposalGuideline() {
    }
}
