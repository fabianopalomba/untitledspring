package com.fegh.springata.dao;

import com.fegh.springata.entity.User;

import java.util.List;

public interface UserDao {
    boolean validate(String userName, String password);

    void Inserisci(User user);

    void Aggiorna(User user);

    void Elimina(User user);

    void eliminaByEmail(String email);

    User userByEmail(String email);

}
