//package com.crick.apis.Service.imple;
//
//import com.crick.apis.Entities.User;
//import com.crick.apis.Repositories.UserRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class CustomUserDetailService implements UserDetailsService {
////    @Autowired
////    private UserRepo userRepo;
//
//    private final UserRepo userRepo;
//
//    @Autowired
//    public CustomUserDetailService(UserRepo userRepo) {
//        this.userRepo = userRepo;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
////        User user =userRepo.findByEmail(username).orElseThrow(()->new RuntimeException("User Not Found !!"));
//        Optional<User> userOptional = userRepo.findByEmail(username);
//        User user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User Not Found !!"));
//        return user;
//    }
//}
package com.crick.apis.Service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.crick.apis.Entities.Users;
import com.crick.apis.Repositories.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found !!"));
    }
}
