package com.noticias.notiegg.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.noticias.notiegg.entidades.Noticia;
@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, String> {
   
    @Query ("SELECT n FROM Noticia WHERE n.titulo = :titulo")
    public Noticia buscarPorTitulo(@Param("titulo") String titulo);
    
}
