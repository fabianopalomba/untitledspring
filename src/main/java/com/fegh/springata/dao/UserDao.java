package com.fegh.springata.dao;

import com.fegh.springata.entity.Rent;
import com.fegh.springata.entity.User;

import java.util.List;

public interface UserDao {
    boolean validate(String userName, String password);

    void Insert(User user);

    void Update(User user);

    void Delete(User user);

    void DeleteByEmail(String email);

    User userByEmail(String email);

    List<Rent> rentByEmail(String email);

}
