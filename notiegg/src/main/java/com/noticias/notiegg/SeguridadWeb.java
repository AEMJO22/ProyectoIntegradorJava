package com.noticias.notiegg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SeguridadWeb  {  
    //Administro el usuario y contraseña que me pide inicialmente el servidor
   
    @Bean
    public UserDetailsService userDetailsService() {
    var user = User.withUsername("root")
    .password("root")
    .roles("read")
            .build();
    return new InMemoryUserDetailsManager(user);
    
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // no sirve para produccion.
    }


   
}
