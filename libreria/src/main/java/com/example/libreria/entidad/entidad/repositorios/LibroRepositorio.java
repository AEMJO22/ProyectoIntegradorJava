package com.example.libreria.entidad.entidad.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.libreria.entidad.entidad.entidades.Libro;

@Repository
// se crea la interface que se extiende desde JPA REPOSITORIY manejando la entidad libro cuya ID es LONG
public interface LibroRepositorio extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    public Libro buscarPorTitulo(@Param("titulo") String titulo); // PARAM hace refencia al titulo que es atributo del libro

    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")// Creo la query y luego hago el metodo donde quiero que guarde la info recibida.
    public List<Libro> buscarPorAutor(@Param("nombre") String nombre); // el parametro nombre hace refenrecia al nombre que voy a buscar en la query

}
