package com.tst.fyugp.service.auth;

import com.tst.fyugp.model.User;
import com.tst.fyugp.model.UserPrincipal;
import com.tst.fyugp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user == null){
            System.out.println(" %s not found");
            throw new UsernameNotFoundException("message from theUsernameNotFoundException");
        }
        return  new UserPrincipal(user);
    }
}