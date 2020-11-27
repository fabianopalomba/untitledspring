package com.fegh.springata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cars", schema = "renting")
public class Car implements Serializable {
    private int carsid;
    private String brand;
    private String model;
    private List<com.fegh.springata.entity.Rent> rents = new ArrayList<>();

    public Car() {
    }

    public Car(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public Car(int carsid, String brand, String model) {
        this.carsid = carsid;
        this.brand = brand;
        this.model = model;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carsid", nullable = false)
    public int getCarsid() {
        return carsid;
    }
    public void setCarsid(int carsid) {
        this.carsid = carsid;
    }

    @Column(name = "brand", nullable = false, length = 45)
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Column(name = "model", nullable = false, length = 45)
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    @JsonIgnore
    @OneToMany (mappedBy = "car",orphanRemoval = true, cascade = CascadeType.MERGE)
    public List<com.fegh.springata.entity.Rent> getRents() {
        return rents;
    }
    public void setRents(List<com.fegh.springata.entity.Rent> rents1){
        this.rents = rents1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return carsid == car.carsid &&
                brand.equals(car.brand) &&
                model.equals(car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carsid, brand, model);
    }
}
