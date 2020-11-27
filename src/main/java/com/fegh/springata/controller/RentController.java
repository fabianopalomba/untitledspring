package com.fegh.springata.controller;
import com.fegh.springata.config.WebMvcConfig;
import com.fegh.springata.dao.UserDao;
import com.fegh.springata.entity.Car;
import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;
import com.fegh.springata.service.CarService;
import com.fegh.springata.service.RentService;
import com.fegh.springata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RentController {

    @Autowired
    private RentService rentService;
    @Autowired
    private UserService userService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping(value = "/newRent")
    public ModelAndView displayNewRentForm() {
        ModelAndView mv = new ModelAndView("newRent");
        mv.addObject("headerMessage", "Insert date");
        return mv;
    }

    @PostMapping(value = "/newRent")
    public ModelAndView passDate(@RequestParam("initDate") String initDate, @RequestParam("finDate") String finDate) {
        ModelAndView mv = new ModelAndView("redirect:/selectCar");
        mv.addObject("initDate",initDate);
        mv.addObject("finDate",finDate);
        return mv;
    }
    @PostMapping(value = "/selectCar")
    public ModelAndView chooseCar(@ModelAttribute("car") Car car, @RequestParam("initDate") String initDate, @RequestParam("finDate") String finDate, HttpSession session) throws ParseException {
        ModelAndView mv = new ModelAndView("redirect:/home");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date datainizio = formatter.parse(initDate);
        Date datafine = formatter.parse(finDate);
        User user = userService.userByEmail((String)session.getAttribute("email"));
        Rent rent = new Rent(car,user,datainizio,datafine);
        rentService.Insert(rent);
        mv.addObject("headerMessage","Rent added");
        return mv;
    }

}
