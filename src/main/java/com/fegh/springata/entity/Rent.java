package com.fegh.springata.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rent", schema = "alphashop")
@AssociationOverrides({
        @AssociationOverride(name = "user",
                joinColumns = @JoinColumn(name = "email", referencedColumnName = "email")),
        @AssociationOverride(name = "car",
                joinColumns = @JoinColumn(name= "id", referencedColumnName = "carsid"))})

public class Rent implements Serializable{
    public int rentid;
    private Car car;
    private User user;
    private Date initDate;
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

    @Column(name = "finDate", nullable = false)
    public Date getFinDate() {
        return finDate;
    }
    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public Car getCar(){
        return car;
    }
    public void setCar(Car car){
        this.car = car;
    }

    @ManyToOne (fetch = FetchType.EAGER)
    public User getUser(){ return user; }
    public void setUser(User user){
        this.user = user;
    }

    public Date getInitDate(){ return initDate; }
    public void setInitDate(Date d){ this.initDate=initDate; }

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
