package com.fegh.springata.entity;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rent", schema = "renting")
@AssociationOverrides({
        @AssociationOverride(name = "user",
                joinColumns = @JoinColumn(name = "user", referencedColumnName = "email")),
        @AssociationOverride(name = "car",
                joinColumns = @JoinColumn(name= "car", referencedColumnName = "carsid"))})

public class Rent implements Serializable{

    public int rentid;
    private Car car;
    private User user;

    /*@NotNull(message = "{rent.initDate.notNull}")
    @Future(message = "{rent.initDate.future}")*/
    private Date initDate;

    /*@NotNull(message = "{rent.finDate.notNull}")
    @Future(message = "{rent.finDate.future}")*/
    private Date finDate;

    public Rent() {
    }

    public Rent(Car car, User user, Date initDate, Date finDate) {
        this.car = car;
        this.user = user;
        this.initDate = initDate;
        this.finDate = finDate;
    }

    public Rent(int rentid, Car car, User user, Date initDate, Date finDate) {
        this.rentid = rentid;
        this.car = car;
        this.user = user;
        this.initDate = initDate;
        this.finDate = finDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rentid", nullable = false)
    public int getRentid(){return rentid;}
    public void setRentid(int rentid) {  this.rentid=rentid;  }

    @Column(name = "initDate", nullable = false)
    public Date getInitDate(){ return initDate; }
    public void setInitDate(Date initDate){ this.initDate=initDate; }

    @Column(name = "finDate", nullable = false)
    public Date getFinDate() {
        return finDate;
    }
    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        this.car = car;
    }

    @ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    public User getUser(){ return user; }
    public void setUser(User user){
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rent rent = (Rent) o;
        return rentid == rent.rentid &&
                car.equals(rent.car) &&
                user.equals(rent.user) &&
                initDate.equals(rent.initDate) &&
                finDate.equals(rent.finDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentid, car, user, initDate, finDate);
    }
}

