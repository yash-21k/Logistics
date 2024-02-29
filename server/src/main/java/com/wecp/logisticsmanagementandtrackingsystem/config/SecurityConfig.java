// package com.wecp.logisticsmanagementandtrackingsystem.config;


// import javax.servlet.http.HttpServletRequest;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.AuthenticationProvider;
// import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
// import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.security.web.util.matcher.RequestMatcher;

// import com.wecp.logisticsmanagementandtrackingsystem.jwt.JwtRequestFilter;
// import com.wecp.logisticsmanagementandtrackingsystem.service.UserService;
 
// @Configuration
// @EnableWebSecurity
// @EnableMethodSecurity
// public class SecurityConfig{
//     private final UserDetailsService userDetailsService;
//     private final JwtRequestFilter jwtRequestFilter;
//     private final PasswordEncoder passwordEncoder;

//     @Autowired
//     public SecurityConfig(UserDetailsService userDetailsService,
//                           JwtRequestFilter jwtRequestFilter,
//                           PasswordEncoder passwordEncoder) {
//         this.userDetailsService = userDetailsService;
//         this.jwtRequestFilter = jwtRequestFilter;
//         this.passwordEncoder = passwordEncoder;
//     }
 

//     @Bean
//     public UserDetailsService userDetailsService() {
//         return new UserService();
//     }

//     // @Bean
//     // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//     //     return http.csrf(csrf -> csrf.disable())
//     //             .authorizeHttpRequests(requests -> requests
//     //                     .requestMatchers(new CustomRequestMatcher("/api/register", "/api/login")).permitAll())
//     //             .authorizeHttpRequests(requests -> requests.requestMatchers(new CustomRequestMatcher("/api/business/*", "/api/customer/*", "/api/driver/*"))
//     //                     .authenticated())
//     //             .sessionManagement(management -> management
//     //                     .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//     //             .authenticationProvider(authenticationProvider())
//     //             .addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class)
//     //             .build();
//     // }
   
//     @Bean
//     public AuthenticationProvider authenticationProvider(){
//         DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//         authenticationProvider.setUserDetailsService(userDetailsService());
//         authenticationProvider.setPasswordEncoder(passwordEncoder);
//         return authenticationProvider;
//     }

//     @Bean
//     public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//         return config.getAuthenticationManager();    
//     }

// private static class CustomRequestMatcher implements RequestMatcher {
//     private String[] patterns;
 
//     public CustomRequestMatcher(String... patterns) {
//         this.patterns = patterns;
//     }
 
//     @Override
//     public boolean matches(HttpServletRequest request) {
//         // TODO Auto-generated method stub
//         String requestURI = request.getRequestURI();
//         for (String pattern : patterns) {
//             if (requestURI.matches(pattern)) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }
 
    
 
//     // @Override
//     // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//     //     auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//     // }
 
//     // @Override
//     // protected void configure(HttpSecurity http) throws Exception {
//     //     http.cors().and().csrf().disable()
//     //             .authorizeRequests()
//     //             .antMatchers(HttpMethod.POST, "/api/register").permitAll()
//     //             .antMatchers(HttpMethod.POST, "/api/login").permitAll()
//     //             .antMatchers(HttpMethod.POST,"/api/business/cargo").hasAuthority("BUSINESS")
//     //             .antMatchers(HttpMethod.POST,"/api/business/assign-cargo").hasAnyAuthority("BUSINESS")
//     //             // .antMatchers(HttpMethod.POST,"/api/").hasAnyAuthority("authority_Name","authority_Name")
//     //             .antMatchers(HttpMethod.PUT,"/api/driver/cargo").hasAnyAuthority("DRIVER")
//     //             .antMatchers(HttpMethod.GET,"/api/business/cargo").hasAnyAuthority("BUSINESS")
//     //             .antMatchers(HttpMethod.GET,"/api/business/drivers").hasAnyAuthority("BUSINESS")
//     //             .antMatchers(HttpMethod.GET,"/api/customer/cargo-status").hasAnyAuthority("CUSTOMER")
//     //             .antMatchers(HttpMethod.GET,"/api/driver/cargo").hasAnyAuthority("DRIVER")
 
//     //             .anyRequest().authenticated()
//     //             .and()
//     //             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 
//     //     http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//     // }
 
    
// }







package com.wecp.logisticsmanagementandtrackingsystem.config;
 
import com.wecp.logisticsmanagementandtrackingsystem.jwt.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
 
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final PasswordEncoder passwordEncoder;
 
    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtRequestFilter jwtRequestFilter,
                          PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }
 
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/register").permitAll()
                .antMatchers(HttpMethod.POST, "/api/login").permitAll()
                .antMatchers(HttpMethod.POST, "/api/business/cargo").hasAuthority("BUSINESS")
                .antMatchers(HttpMethod.GET, "/api/business/drivers").hasAuthority("BUSINESS")
                .antMatchers(HttpMethod.GET, "/api/business/cargo").hasAuthority("BUSINESS")
                .antMatchers(HttpMethod.POST, "/api/business/assign-cargo").hasAuthority("BUSINESS")
                .antMatchers(HttpMethod.GET, "/api/driver/cargo").hasAuthority("DRIVER")
                .antMatchers(HttpMethod.PUT, "/api/driver/update-cargo-status").hasAuthority("DRIVER")
                .antMatchers(HttpMethod.GET, "/api/customer/cargo-status").hasAuthority("CUSTOMER")
                .anyRequest().authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
 
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
 
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}