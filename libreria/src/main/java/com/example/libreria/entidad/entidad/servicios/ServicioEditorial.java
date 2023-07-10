package com.example.libreria.entidad.entidad.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.libreria.Excepciones.MiException;
import com.example.libreria.entidad.entidad.entidades.Editorial;
import com.example.libreria.entidad.entidad.repositorios.EditorialRepositorio;

@Service
public class ServicioEditorial {

    
   // @Autowired
    EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        validar(nombre);
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre);

        editorialRepositorio.save(editorial);

    }
@Transactional(readOnly = true)
    public List<Editorial> listarEditoriales() {
        List<Editorial> editoriales = new ArrayList<>();
        editoriales = editorialRepositorio.findAll();
        return editoriales;
    }
@Transactional
    public void mofificarEditorial(String id, String nombre) throws MiException{
        Optional<Editorial> respuesta = editorialRepositorio.findById(id);

        if (respuesta.isPresent()) {
            Editorial editorial = respuesta.get();
            editorial.setNombre(nombre);
            editorialRepositorio.save(editorial);
        }

    }
    @Transactional(readOnly = true)
    public Editorial getOne(String id) {
        return editorialRepositorio.getOne(id);
    }

    private void validar(String nombre) throws MiException {

        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("el nombre de la editorial no puede ser nulo o estar vacio");
        }
    }
}
