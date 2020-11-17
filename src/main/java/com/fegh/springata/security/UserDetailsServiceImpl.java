package com.fegh.springata.security;

import com.fegh.springata.dao.UserDao;
import com.fegh.springata.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userDao.userByEmail(email);
        if(user==null) {
            throw new UsernameNotFoundException("Utente inesistente");
        }
        return new MyUserDetails(user);
    }
}
