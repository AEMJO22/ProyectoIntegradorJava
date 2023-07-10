package com.example.libreria.entidad.entidad.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.libreria.Excepciones.MiException;
import com.example.libreria.entidad.entidad.entidades.Autor;
import com.example.libreria.entidad.entidad.servicios.ServicioAutor;

@RestController
@RequestMapping("/autor") //llamo a la web autor.
public class AutorControlador { //localhost:8080/autor para ingresar directamente a esta web.

   
    @Autowired
    public ServicioAutor servicioAutor;

    @GetMapping("/registrar") // creo otro enlace con el nombre "REGISTRAR" localhost:8080/autor/registrar

    public String registrar() {
        return "autor_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) {

        try {
            servicioAutor.crearAutor(nombre);
            modelo.put("exito", "El Autor fue registrado correctamente!");
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());

            return "autor_form.html";
        }

        return "index.html";
    }
    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Autor> autores = servicioAutor.listarAutores();

        modelo.addAttribute("autores", autores);

        return "autor_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {
        modelo.put("autor", servicioAutor.getOne(id));

        return "autor_modificar.html";
    }

    @PostMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, String nombre, ModelMap modelo) {
        try {
            servicioAutor.modificarAutor(nombre, id);

            return "redirect:../lista";
        } catch (MiException ex) {
            modelo.put("error", ex.getMessage());
            return "autor_modificar.html";
        }

    }

   

   
}
