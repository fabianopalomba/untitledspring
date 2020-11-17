package com.fegh.springata.controller;

import com.fegh.springata.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController
{
    @RequestMapping(value="/index")
    public String getWelcome(Model model)
    {
        model.addAttribute("intestazione", "Benvenuto");
        model.addAttribute("saluti", "Benvenuto su Renting Car");
        return "index";
    }

    @GetMapping(value="/home")
    public ModelAndView getHome()
    {
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("intestazione", "Benvenuto");
        mv.addObject("saluti", "Benvenuto su Renting Car");
        return mv;
    }


}
