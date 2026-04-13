//package com.coworking.coworking_booking_system.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/api/workspaces/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//
//        return http.build();
//    }
//}

/*
sene verdiyim MVP de bu metodlar olmalidi  
GET /api/workspaces
GET /api/workspaces/available?date=...
POST /api/bookings
GET /api/bookings/my
DELETE /api/bookings/{id}
ADMIN: POST /api/workspaces
ADMIN: PUT /api/workspaces/{id}
ADMIN: GET /api/bookings 

sen ise ancaq bunlari yaradibsan 
GET /api/workspaces
GET /api/workspaces/available
POST /api/bookings
GET /api/bookings/user/{userId} 


Bunlar yoxdu 
GET /api/bookings/my
DELETE /api/bookings/{id}
POST /api/workspaces
PUT /api/workspaces/{id}
GET /api/bookings 

 

SecurityConfig.java hamisi kommentlenib 
Basic Auth 
USER / ADMIN icazeler 
passwordlar xeshlenmir 
Mvp de men yazmisdim ki Basic Auth BCrypt olsun hec olmasa 

*/
