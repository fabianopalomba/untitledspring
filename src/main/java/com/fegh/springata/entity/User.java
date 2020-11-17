package com.fegh.springata.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "renting")
public class User implements Serializable {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String role;
    private boolean enabled;
    private List<com.fegh.springata.entity.Rent> rents = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, String phone, String email, String password, String role, boolean enabled) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.enabled = enabled;
    }

    public User(String firstName, String lastName, String phone, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = "USER";
        this.enabled = true;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @Column(name = "email", nullable = false, length = 45)
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "firstName", nullable = false, length = 45)
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "lastName", nullable = false, length = 45)
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone", nullable = false, length=10)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "password", nullable = false, length=64)
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "role", nullable = false, length=4)
    public String getRole(){ return role; }
    public void setRole(String role) { this.role = role;}

    @Column(name = "enabled", nullable = false)
    public boolean isEnabled(){ return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled;}

    @OneToMany(mappedBy = "user",orphanRemoval = true, cascade = CascadeType.ALL)
    public List<com.fegh.springata.entity.Rent> getRents() {
        return rents;
    }
    public void setRents(List<com.fegh.springata.entity.Rent> rents) {
        this.rents = rents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return enabled == user.enabled &&
                firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                phone.equals(user.phone) &&
                email.equals(user.email) &&
                password.equals(user.password) &&
                role.equals(user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phone, email, password, role, enabled);
    }
}
