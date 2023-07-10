package com.example.libreria.entidad.entidad.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.libreria.entidad.entidad.entidades.Imagen;

@Repository
public interface ImagenRepositorio extends JpaRepository<Imagen,String> {
    
}
