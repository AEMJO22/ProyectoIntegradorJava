package com.noticias.notiegg.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.noticias.notiegg.servicios.NoticiaServicios;

@Controller
@RequestMapping("/") // localhost :8080/la barra indica que el controlador va a ser llamado luego de colocar la barra en el localhost.
public class PortalControlador {
    @Autowired
    private NoticiaServicios noticiaServicios;

    
    @GetMapping("/") // tambien se llama como localhost:8080/
    public String index() {
        return "index.html"; // me va a devolver la pagina index que esta en los html.
    }
}
