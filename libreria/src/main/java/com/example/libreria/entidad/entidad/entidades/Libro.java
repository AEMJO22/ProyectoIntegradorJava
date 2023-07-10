package com.example.libreria.entidad.entidad.entidades;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;



@Entity
public class Libro {
    @Id
    private Long ISBN;

    private String titulo;
    private Integer ejemplares;

    
    @Temporal(TemporalType.DATE)
    private Date Alta;

    

    @ManyToOne
    private Autor autor;

    @ManyToOne
    private Editorial editorial;

    public Libro() {
    }

    public Libro(Long iSBN, String titulo, Integer ejemplares, Date alta, Autor autor, Editorial editorial) {
        ISBN = iSBN;
        this.titulo = titulo;
        this.ejemplares = ejemplares;
        Alta = alta;
        this.autor = autor;
        this.editorial = editorial;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long iSBN) {
        ISBN = iSBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Date getAlta() {
        return Alta;
    }

    public void setAlta(Date alta) {
        Alta = alta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

   

}
