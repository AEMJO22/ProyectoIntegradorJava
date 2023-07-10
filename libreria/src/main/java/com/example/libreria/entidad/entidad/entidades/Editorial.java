package com.example.libreria.entidad.entidad.entidades;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;

@AllArgsConstructor

@Entity
public class Editorial {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String ID;
    private String nombre;

   
}
