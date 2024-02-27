// package com.wecp.logisticsmanagementandtrackingsystem.Controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.wecp.logisticsmanagementandtrackingsystem.dto.LoginRequest;
// import com.wecp.logisticsmanagementandtrackingsystem.dto.LoginResponse;
// import com.wecp.logisticsmanagementandtrackingsystem.entity.*;
// import com.wecp.logisticsmanagementandtrackingsystem.jwt.JwtUtil;
// import com.wecp.logisticsmanagementandtrackingsystem.service.BusinessService;
// import com.wecp.logisticsmanagementandtrackingsystem.service.CustomerService;
// import com.wecp.logisticsmanagementandtrackingsystem.service.DriverService;
// import com.wecp.logisticsmanagementandtrackingsystem.service.UserService;

// @RestController
// @RequestMapping("/api")
// public class RegisterAndLoginController {

//     @Autowired
//     private UserService userService;

//     @Autowired
//     private BusinessService businessService;

//     @Autowired
//     private CustomerService customerService;

//     @Autowired
//     private DriverService driverService;

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     @Autowired
//     private JwtUtil jwtUtil;

//     // @PostMapping("/register")
//     // public ResponseEntity<?> registerUser(@RequestBody User user) {
//     //     User registeredUser = userService.registerUser(user);
//     //     if (registeredUser.getRole().equals("BUSINESS")) {
//     //         Business business = new Business();
//     //         business.setName(registeredUser.getUsername());
//     //         business.setEmail(user.getEmail());
//     //         businessService.registerBusiness(business);
//     //         return ResponseEntity.ok(business);
//     //     } else if (registeredUser.getRole().equals("CUSTOMER")) {
//     //         Customer customer = new Customer();
//     //         customer.setName(registeredUser.getUsername());
//     //         customer.setEmail(user.getEmail());
//     //         return ResponseEntity.ok(customerService.createCustomer(customer));
//     //     } else {
//     //         Driver driver = new Driver();
//     //         driver.setName(registeredUser.getUsername());
//     //         driver.setEmail(user.getEmail());
//     //         return ResponseEntity.ok(driverService.createDriver(driver));
//     //     }
//     // }

//     @PostMapping("/login")
//     public ResponseEntity<LoginResponse> loginUser(@RequestBody LoginRequest loginRequest) {
//         return null;
//     }


// }