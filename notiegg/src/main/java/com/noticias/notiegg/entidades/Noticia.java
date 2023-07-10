package com.noticias.notiegg.entidades;





import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Noticia {
    public Noticia(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Noticia() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    @Id
    private String titulo;

    private String cuerpo;

   
}
