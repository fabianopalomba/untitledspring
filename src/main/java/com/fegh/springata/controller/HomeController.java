package com.fegh.springata.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController
{
    @RequestMapping(value="home")
    public String getWelcome(Model model)
    {
        model.addAttribute("intestazione", "Benvenuto");
        model.addAttribute("saluti", "Benvenuto su Renting Car");
        return "home";
    }

}
