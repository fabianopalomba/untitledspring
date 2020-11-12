package com.fegh.springata.service;

import com.fegh.springata.dao.RentDao;
import com.fegh.springata.entity.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("rentService")
@Transactional
public class RentServiceImpl implements RentService{
    @Autowired
    private RentDao rentDao;

    @Override
    public List<Rent> rentByEmail(String email) {
        return rentDao.rentByEmail(email);
    }

    @Override
    public void Inserisci(Rent rent) {
        rentDao.Inserisci(rent);
    }
}
