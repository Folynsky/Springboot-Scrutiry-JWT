package com.exampleJWT.JWT.service;

import com.exampleJWT.JWT.model.UserPrincipal;
import com.exampleJWT.JWT.model.Users;
import com.exampleJWT.JWT.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDatailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = repo.findByUsername(username);
        if (user == null){
            System.out.println("Usuario no encontrado");
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new UserPrincipal(user);
    }
}
