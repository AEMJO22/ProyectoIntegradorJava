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
import com.example.libreria.entidad.entidad.entidades.Editorial;
import com.example.libreria.entidad.entidad.entidades.Libro;
import com.example.libreria.entidad.entidad.servicios.ServicioAutor;
import com.example.libreria.entidad.entidad.servicios.ServicioEditorial;
import com.example.libreria.entidad.entidad.servicios.ServicioLibros;

@RestController
@RequestMapping("/libro")
public class LibroControlador {

    @Autowired
    public ServicioLibros servicioLibros;
    @Autowired
    public ServicioAutor servicioAutor;
    @Autowired
    public ServicioEditorial servicioEditorial;

    @GetMapping("/registar") // localhost:8080/libro/registrar

    public String registrar(ModelMap modelo) {
        List<Autor> autores = servicioAutor.listarAutores();
        List<Editorial> editoriales = servicioEditorial.listarEditoriales();

        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);
        return "libro_form.html";
    }

    @PostMapping("/registro")
    public String registro(@RequestParam (required = false) Long ISBN, @RequestParam String titulo, @RequestParam (required = false)Integer ejemplares,
            @RequestParam String idAutor, @RequestParam String idEditorial, ModelMap modelo) {

        try {
            servicioLibros.crearLibros(ISBN, titulo, ejemplares, idAutor, idEditorial);
            modelo.put("exito", "El libro fue cargadado correctamente");

        } catch (MiException ex) {
            List<Autor> autores = servicioAutor.listarAutores();
            List<Editorial> editoriales = servicioEditorial.listarEditoriales();

            modelo.put("Error", ex.getMessage());
            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);
            modelo.put("error", ex.getMessage());
            return "libro_form.html";
        }
        return "index.html";
    }
    @GetMapping("/lista")
    public String listar(ModelMap modelo) {
        List<Libro> libros = servicioLibros.listarLibros();
        modelo.addAttribute("libros", libros);

        return "libro_list";
    }
    @GetMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn, ModelMap modelo) {

        modelo.put("libro", servicioLibros.getOne(isbn));

        List<Autor> autores = servicioAutor.listarAutores();
        List<Editorial> editoriales = servicioEditorial.listarEditoriales();

        modelo.addAttribute("autores", autores);
        modelo.addAttribute("editoriales", editoriales);

        return "libro_modificar.html";
    }
    
    @PostMapping("/modificar/{isbn}")
    public String modificar(@PathVariable Long isbn, String titulo, Integer ejemplares, String idAutor, String idEditorial, ModelMap modelo) {
        try {
            List<Autor> autores = servicioAutor.listarAutores();
            List<Editorial> editoriales = servicioEditorial.listarEditoriales();

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);

            servicioLibros.modificarLibro(isbn, titulo, idAutor, idEditorial, ejemplares);

            return "redirect:../lista";

        } catch (MiException ex) {
            List<Autor> autores = servicioAutor.listarAutores();
            List<Editorial> editoriales = servicioEditorial.listarEditoriales();

            modelo.put("error", ex.getMessage());

            modelo.addAttribute("autores", autores);
            modelo.addAttribute("editoriales", editoriales);

            return "libro_modificar.html";
        }

    }
}
