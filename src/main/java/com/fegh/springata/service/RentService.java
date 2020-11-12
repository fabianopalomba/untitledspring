package com.fegh.springata.service;

import com.fegh.springata.entity.Rent;

import java.util.List;

public interface RentService {

    List<Rent> rentByEmail(String email);

    void Inserisci(Rent rent);

}
