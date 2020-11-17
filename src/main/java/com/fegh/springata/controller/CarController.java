package com.fegh.springata.controller;

import com.fegh.springata.entity.Car;
import com.fegh.springata.entity.Rent;
import com.fegh.springata.service.CarService;
import com.fegh.springata.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }
    @GetMapping(value = "/selectCar")
    public ModelAndView displayCar(@RequestParam("initDate") String initDate, @RequestParam("finDate") String finDate) throws ParseException {
        ModelAndView mv = new ModelAndView("selectCar");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date datainizio = formatter.parse(initDate);
        Date datafine = formatter.parse(finDate);
        if(datafine.after(datainizio) && datainizio.after(new Date())){
            List<Car> cars = carService.SelCarsByDate(datainizio,datafine);
            mv.addObject("car",new Car());
            mv.addObject("cars",cars);
            mv.addObject("headerMessage", "Show cars");}
        else {
            mv.addObject("headerMessage","DATE NON VALIDE");
            mv.setViewName("redirect:/newRent"); }
        return mv;
    }

}

