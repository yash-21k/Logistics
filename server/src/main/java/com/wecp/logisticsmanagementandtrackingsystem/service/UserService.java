// package com.wecp.logisticsmanagementandtrackingsystem.service;
 
 
// import com.wecp.logisticsmanagementandtrackingsystem.entity.User;
// import com.wecp.logisticsmanagementandtrackingsystem.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;
 
// import java.util.ArrayList;
 
// @Service
// public class UserService implements UserDetailsService {
 
//     @Autowired
//     private UserRepository userRepository;
 
 
//     private PasswordEncoder passwordEncoder;
 
 
//     public User registerUser(User user) {
//         // encode password before saving to database
//         user.setPassword(passwordEncoder.encode(user.getPassword()));
//         return userRepository.save(user);
//     }
 
//     public User getUserByUsername(String username) {
//         // get user by user name and return user object
//         return userRepository.findByUsername(username);
//     }
 
//     @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         // load user by username and return user details
//         return null;
//     }
 
//     }
 