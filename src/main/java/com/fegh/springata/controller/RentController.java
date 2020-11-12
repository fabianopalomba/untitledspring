package com.fegh.springata.controller;

import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;
import com.fegh.springata.service.CarService;
import com.fegh.springata.service.RentService;
import com.fegh.springata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class RentController {

    @Autowired
    private RentService rentService;

    @Autowired
    public RentController(RentService rentService) {
        this.rentService = rentService;
    }

    @GetMapping(value = "/myRent")
    public ModelAndView displayMyRent() {
        ModelAndView mv = new ModelAndView("myRent");
        mv.addObject("headerMessage", "Show my rents");
        return mv;
    }

}
