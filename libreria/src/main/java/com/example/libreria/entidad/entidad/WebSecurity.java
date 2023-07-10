package com.example.libreria.entidad.entidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

import com.example.libreria.entidad.entidad.servicios.ServicioUsuario;

@Configuration
@EnableWebSecurity

public class WebSecurity extends WebSecurityConfiguration {
    @Autowired
    public ServicioUsuario servicioUsuario;

    protected void configure(HttpSecurity http) throws Exception {

http.authorizeRequests()

}
