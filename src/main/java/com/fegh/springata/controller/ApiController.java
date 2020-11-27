package com.fegh.springata.controller;

import com.fegh.springata.entity.Car;
import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;
import com.fegh.springata.service.CarService;
import com.fegh.springata.service.RentService;
import com.fegh.springata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private CarService carService;

    @Autowired
    private RentService rentService;

    @Autowired
    private UserService userService;

    @Autowired
    public ApiController(CarService carService,RentService rentService,UserService userService){
        this.carService = carService;
        this.rentService = rentService;
        this.userService = userService;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        try {
            List<Car> cars = new ArrayList();
            carService.GetEvery().forEach(cars::add);
            if (cars.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{email:.+}")
    public ResponseEntity<User> getUserByEmail(@PathVariable("email") String email) {
        try {
            User user = userService.userByEmail(email);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/delete/{email:.+}")
    public ResponseEntity<HttpStatus> deleteByEmail(@PathVariable("email") String email) {
        try {
            userService.DeleteByEmail(email);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<HttpStatus>loginUser(@RequestBody String[] id){
        if(userService.validate(id[0],id[1])){
            return new ResponseEntity<>(HttpStatus.OK);}
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/addRent")
    public ResponseEntity<HttpStatus>addNewRent(@RequestBody String[] strings) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date datainizio = formatter.parse(strings[0]);
        Date datafine = formatter.parse(strings[1]);
        Car car = carService.SelById(Integer.parseInt(strings[2]));
        User user1 = userService.userByEmail(strings[3]);
        Rent rent = new Rent(car,user1,datainizio,datafine);
        rentService.Insert(rent);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/rents")
    public ResponseEntity<List<Rent>> displayRents(@RequestBody String email){
        List<Rent> rents = userService.rentByEmail(email);
        return new ResponseEntity<>(rents,HttpStatus.OK);
    }

    @PostMapping("/selectCars")
    public ResponseEntity<List<Car>> displayAvailableCars(@RequestBody String[] dates) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date datainizio = formatter.parse(dates[0]);
        Date datafine = formatter.parse(dates[1]);
        if (datafine.after(datainizio) && datainizio.after(new Date())) {
            List<Car> cars = carService.SelCarsByDate(datainizio, datafine);
            return new ResponseEntity<>(cars, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<HttpStatus>register(@RequestBody User user) {
        User user1 = new User(user.getFirstName(), user.getLastName(), user.getPhone(), user.getEmail(), user.getPassword());
        if(userService.userByEmail(user1.getEmail()).getEmail().equals("")){
        userService.Insert(user1);
        return new ResponseEntity<>(HttpStatus.OK);}
        else {
            userService.Update(user1);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}



