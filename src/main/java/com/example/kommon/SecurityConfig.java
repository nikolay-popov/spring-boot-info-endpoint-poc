package com.example.kommon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  // not overriding configure methods - all endpoints are secured by default

  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    // adding a user - primary for tests
    UserDetails user = new User("user", "pwd", Collections.emptyList());

    return new InMemoryUserDetailsManager(new ArrayList<UserDetails>() {{ add(user); }});
  }

}
