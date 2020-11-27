package com.fegh.springata.dao;

import com.fegh.springata.entity.Car;

import java.util.Date;
import java.util.List;

public interface CarDao {

    List<Car> SelCarsByDate(Date dateinit, Date datefini);

    List<Car> SelCarsByBrand(String brand);

    List<Car> GetEvery();

    Car SelById(Integer integer);
}
