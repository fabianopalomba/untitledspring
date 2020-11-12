package com.fegh.springata.dao;

import com.fegh.springata.entity.Rent;

import java.util.List;

public interface RentDao {

    List<Rent> rentByEmail(String email);

    void Inserisci(Rent rent);

}
