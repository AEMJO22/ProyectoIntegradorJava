package com.example.libreria.entidad.entidad.servicios;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.libreria.Excepciones.MiException;
import com.example.libreria.entidad.entidad.entidades.Autor;
import com.example.libreria.entidad.entidad.entidades.Editorial;
import com.example.libreria.entidad.entidad.entidades.Libro;
import com.example.libreria.entidad.entidad.repositorios.AutorRepositorio;
import com.example.libreria.entidad.entidad.repositorios.EditorialRepositorio;
import com.example.libreria.entidad.entidad.repositorios.LibroRepositorio;

@Service
public class ServicioLibros {

    //@Autowired
    private LibroRepositorio libroRepositorio;
   // @Autowired // esto se pone para que el objeto sea manejado e inicializado por el servidor de aplicaciones. Inyeccion de dependencia. 
    private AutorRepositorio autorRepositorio;

   // @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearLibros(Long ISBN, String titulo, Integer ejemplares, String idAutor, String idEditorial)
            throws MiException {

        validar(ISBN, titulo, ejemplares, idAutor, idEditorial);
        Optional<Libro> respuesta = libroRepositorio.findById(ISBN);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);

        Autor autor = autorRepositorio.findById(idAutor).get(); // Al autor lo inicializo y despues del igual le paso el metodo del autor repositorio. Se usa este metodo para poder buscar el autor en el repositorio y setearlo mas abajo
        Editorial editorial = editorialRepositorio.findById(idEditorial).get();
        if (respuestaAutor.isPresent()) {

            autor = respuestaAutor.get();
        }

        if (respuestaEditorial.isPresent()) {

            editorial = respuestaEditorial.get();
        }
        Libro libro = new Libro(); // instancio libro y luego seteo mas abajo los atributos isbn, titulo y ejemplares.
        libro.setISBN(ISBN);
        libro.setTitulo(titulo);
        libro.setEjemplares(ejemplares);

        libro.setAlta(new Date()); //Agrego la fecha de alta y le paso un NEW DATE para que se crea con la fecha del dia.
        libro.setAutor(autor);
        libro.setEditorial(editorial);

        libroRepositorio.save(libro); // una vez que arriba estan todos los atributos completos, se puede guardar el libro con le metodo SAVE. llamando al repositorio.
    }

    @Transactional(readOnly = true)
    public List<Libro> listarLibros() {

        List<Libro> libros = new ArrayList<>();
        libros = libroRepositorio.findAll();
        return libros;

    }

    @Transactional
    public void modificarLibro(Long ISBN, String titulo, String idAutor, String idEditorial, Integer ejemplares) throws MiException {
        validar(ISBN, titulo, ejemplares, idAutor, idEditorial);
        Optional<Libro> respuesta = libroRepositorio.findById(ISBN);
        Optional<Autor> respuestaAutor = autorRepositorio.findById(idAutor);
        Optional<Editorial> respuestaEditorial = editorialRepositorio.findById(idEditorial);
        Autor autor = new Autor();
        Editorial editorial = new Editorial();

        if (respuestaAutor.isPresent()) {
            autor = respuestaAutor.get();

        }
        if (respuestaEditorial.isPresent()) {
            editorial = respuestaEditorial.get();

        }
        if (respuesta.isPresent()) {
            Libro libro = respuesta.get();
            libro.setTitulo(titulo);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            libro.setEjemplares(ejemplares);

            libroRepositorio.save(libro);
        }
    }

    @Transactional(readOnly = true)
    public Libro getOne(Long ISBN) {
        return libroRepositorio.getOne(ISBN);
    }

    private void validar(Long ISBN, String titulo, Integer ejemplares, String idAutor, String idEditorial)
            throws MiException {

        if (ISBN == null) {
            throw new MiException("El ISBN no puede ser nulo.");

        }

        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El titulo no puede ser nulo.");
        }
        if (ejemplares == null) {
            throw new MiException("El ejemplares no puede ser nulo.");
        }
        if (idAutor.isEmpty() || idAutor == null) {
            throw new MiException("El autor no puede ser nulo.");
        }
        if (idEditorial.isEmpty() || idEditorial == null) {
            throw new MiException("El editorial no puede ser nulo.");
        }

    }
}
