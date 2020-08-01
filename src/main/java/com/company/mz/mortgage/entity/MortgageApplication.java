package com.company.mz.mortgage.entity;


import javax.persistence.*;

@Entity
@Table(name = "mortgage_application")
public class MortgageApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private Resolution resolution;

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public MortgageApplication() {
    }

    public MortgageApplication(String name, Resolution resolution) {
        this.name = name;
        this.resolution = resolution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
