package com.example.libreria.entidad.entidad.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.libreria.entidad.entidad.entidades.Autor;

@Repository

public interface AutorRepositorio extends JpaRepository <Autor, String> { // le paso un objeto Autor y la llave de tipo String

}