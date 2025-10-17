package com.authserviceex1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.authserviceex1.service.CustomerUserDetailsService;
import com.authserviceex1.service.JwtFilter;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

    @Autowired
    private CustomerUserDetailsService customerUserDetailsService;

    @Autowired
    private JwtFilter filter;

    @Bean
    public PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerUserDetailsService);
        authProvider.setPasswordEncoder(getEncoder());
        return authProvider;
    }
    
    @Bean
   	public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception{
    	
    	String[] publicEndpoints = {
    		    "/api/v1/auth/register/doctor",
    		    "/api/v1/auth/register/patient",
    		    "/api/v1/auth/login",
    		    "/api/v1/auth/update-password",
    		    "/api/v1/welcome/**",    // ✅ add this line
    		    "/v3/api-docs/**",
    		    "/swagger-ui/**",
    		    "/swagger-ui.html",
    		    "/swagger-resources/**",
    		    "/webjars/**"
    		};


   		
   		http.authorizeHttpRequests( req -> {
   			req.requestMatchers(publicEndpoints)
   			   .permitAll()
   			   .requestMatchers("/api/v1/welcome/hello").hasAnyRole("ADMIN","DOCTOR")
   			.requestMatchers("/api/v1/welcome/hi").hasAnyRole("PATIENT","ADMIN")
   			   .anyRequest()
   			   .authenticated();			
   		}) .authenticationProvider(authProvider())
           .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
   		
   		return http.csrf().disable().build();
   	}
}
