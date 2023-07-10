package com.example.libreria.entidad.entidad.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.libreria.Excepciones.MiException;
import com.example.libreria.entidad.entidad.entidades.Autor;
import com.example.libreria.entidad.entidad.repositorios.AutorRepositorio;


@Service
public class ServicioAutor {

   //@Autowired
    AutorRepositorio autorRepositorio;

    @Transactional
    public void crearAutor(String nombre) throws MiException {
        validar(nombre);

        Autor autor = new Autor();

        autor.setNombre(nombre);
        autorRepositorio.save(autor);
    }
    
          
    @Transactional(readOnly = true)
    public List<Autor> listarAutores() {
        List<Autor> autores = new ArrayList<>();
        autores = autorRepositorio.findAll();
        return autores;
    }

    public void modificarAutor(String nombre, String id) throws MiException {
        validar(nombre);
        Optional<Autor> respuesta = autorRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Autor autor = respuesta.get();
            autor.setNombre(nombre);
            autorRepositorio.save(autor);

        }

    }
    @Transactional(readOnly = true)
    public Autor getOne(String id) {
        return autorRepositorio.getOne(id);
    }

    @Transactional
    public void eliminar(String id) throws MiException {

        Autor autor = autorRepositorio.getById(id);

        autorRepositorio.delete(autor);

    }

    private void validar(String nombre) throws MiException {
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El titulo no puede estar vacio o ser nulo.");
        
        }
    
    
    }

}
