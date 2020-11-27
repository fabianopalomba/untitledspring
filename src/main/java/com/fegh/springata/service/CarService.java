package com.fegh.springata.service;

import com.fegh.springata.entity.Car;

import java.util.Date;
import java.util.List;

public interface CarService {

    List<Car> SelCarsByDate(Date dateinit, Date datefini);

    List<Car> SelCarsByBrand(String brand);

    List<Car> GetEvery();

    Car SelById(Integer integer);

}
