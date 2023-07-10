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
import com.example.libreria.entidad.entidad.entidades.Editorial;
import com.example.libreria.entidad.entidad.servicios.ServicioEditorial;

@RestController
@RequestMapping("/editorial")
public class EditorialControlador {
    @Autowired
    public ServicioEditorial servicioEditorial;

    @GetMapping("/registrar") //localhost:8080/autor/registrar
    public String registrar() {
        return "editorial_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, ModelMap modelo) {

        try {
           servicioEditorial.crearEditorial(nombre);

            modelo.put("exito", "La Editorial fue registrada correctamente!");
        } catch (MiException ex) {

            modelo.put("error", ex.getMessage());
            return "editorial_form.html";
        }

        return "index.html";
    }

    @GetMapping("/lista")
    public String listar(ModelMap modelo) {

        List<Editorial> editoriales = servicioEditorial.listarEditoriales();

        modelo.addAttribute("editoriales", editoriales);

        return "editorial_list.html";
    }

    @GetMapping("/modificar/{id}")
    public String modificar(@PathVariable String id, ModelMap modelo) {
        modelo.put("editorial", servicioEditorial.getOne(id));

        return "editorial_modificar.html";
    }

}
