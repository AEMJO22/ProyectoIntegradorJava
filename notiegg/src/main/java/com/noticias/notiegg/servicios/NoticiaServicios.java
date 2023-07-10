package com.noticias.notiegg.servicios;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noticias.notiegg.entidades.Noticia;
import com.noticias.notiegg.excepciones.MisExcepciones;
import com.noticias.notiegg.repositorios.NoticiaRepositorio;


@Service
public class NoticiaServicios {

@Autowired
private NoticiaRepositorio noticiaRepositorio; // PERSISITIR le indico al programa que la variable va a ser inicializada por el repo con le autowired.

@Transactional   
public void crearNoticias(String titulo, String cuerpo) throws MisExcepciones{

    validar(titulo, cuerpo);
    Noticia noticia = new Noticia();
    noticia.setTitulo(titulo);
    noticia.setCuerpo(cuerpo);
  

    noticiaRepositorio.save(noticia);
}
    
public List<Noticia> listarNoticias() {
    List<Noticia> noticias = new ArrayList();
    noticias = noticiaRepositorio.findAll();
    return noticias;
}

public void modificarNoticia(String titulo, String cuerpo) throws MisExcepciones {
    validar(titulo, cuerpo);
    Optional<Noticia> respuesta = noticiaRepositorio.findById(titulo);

    if (respuesta.isPresent()) {
        Noticia noticia = respuesta.get();
        noticia.setTitulo(titulo);
        noticia.setCuerpo(cuerpo);
       
        noticiaRepositorio.save(noticia);
    }

}

private void validar(String titulo, String cuerpo) throws MisExcepciones { // como el metodo lo voy a usar unicamente en esta clase le pongo private.
    if (titulo == null || titulo.isEmpty() ){
    throw new MisExcepciones("El titulo no puede estar vacio.");
}
if (cuerpo == null || cuerpo.isEmpty()) {
    throw new MisExcepciones("El cuerpo de la noticia debe completarse.");
}



}
}
