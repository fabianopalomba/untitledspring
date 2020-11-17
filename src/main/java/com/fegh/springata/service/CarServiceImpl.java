package com.fegh.springata.service;

import com.fegh.springata.dao.CarDao;
import com.fegh.springata.entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService{

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> SelCarsByDate(Date dateinit, Date datefini) {
        return carDao.SelCarsByDate(dateinit,datefini);
    }

    @Override
    public List<Car> SelCarsByBrand(String brand) {
        return carDao.SelCarsByBrand(brand);
    }

    @Override
    public List<Car> GetEvery() {
        return carDao.GetEvery();
    }
}
