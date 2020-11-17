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
    public void Insert(Rent rent) {
        rentDao.Insert(rent);
    }
}
