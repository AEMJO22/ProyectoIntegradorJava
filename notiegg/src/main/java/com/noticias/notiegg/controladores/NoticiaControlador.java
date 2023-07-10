package com.noticias.notiegg.controladores;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noticias.notiegg.entidades.Noticia;
import com.noticias.notiegg.excepciones.MisExcepciones;
import com.noticias.notiegg.servicios.NoticiaServicios;
// en esta capa voy a colocar toodo lo referido a la transferencia de datos entre java, base de datos y html.
@Controller
@RequestMapping("/crearnoticias") // localhost:8080/crearnoticias //
public class NoticiaControlador {
    @Autowired
    private NoticiaServicios noticiaServicios;

   
    @GetMapping("/crear") // localhost:8080/crearnoticias/crear //
    public String registrar(ModelMap modelo) {
        List<Noticia> noticia = noticiaServicios.listarNoticias(); // aca cargo las noticias creadas a un ARRAY
        modelo.addAttribute("noticia", noticia);
        return "VistaNoticia.html";
    }
    
    @PostMapping("/subir")
    public String registro(@RequestParam String titulo, @RequestParam String cuerpo, ModelMap modelo) {
        System.out.println("TITULO" + titulo);
        
        try {
            noticiaServicios.crearNoticias(titulo, cuerpo);
            modelo.put("exito", "La noticia fué cargada correctamente!.");
        } catch (MisExcepciones e) {
            
            modelo.put("error", e.getMessage());
             return "VistaNoticia.html";
        }
        return "/";
    }
    @GetMapping("/lista") // Aca voy a hacer el listado de todas las noticias agregadas para poder verlas.
    public String listar(ModelMap modelo) {
        List<Noticia> noticia = noticiaServicios.listarNoticias();
        modelo.addAttribute("noticias", noticia);
        return "VistaAdmin.html";
    }

}
