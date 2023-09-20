/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import enums.Colores;
import enums.NvlResistencia;


public class Armadura {

    private Colores colorPrimario;
    private Colores colorSecundario;
    private NvlResistencia nvlResistencia;
            
    private Botas botas;
    private Guantes guantes;
    private Casco casco;
    
    private Integer nvlSalud;
    private Integer nvlEnergia;
    private Boolean generador;
    
    private Integer distanciaRecorrida;
    private Integer posicX;
    private Integer posicY;
    private Integer posicZ;

    public Armadura() {
    }

    public Armadura(Colores colorPrimario, Colores colorSecundario, NvlResistencia nvlResistencia, Botas botas, Guantes guantes, Casco casco, Integer nvlSalud, Integer nvlEnergia, Boolean generador, Integer distanciaRecorrida, Integer posicX, Integer posicY, Integer posicZ) {
        this.colorPrimario = colorPrimario;
        this.colorSecundario = colorSecundario;
        this.nvlResistencia = nvlResistencia;
        this.botas = botas;
        this.guantes = guantes;
        this.casco = casco;
        this.nvlSalud = nvlSalud;
        this.nvlEnergia = nvlEnergia;
        this.generador = generador;
        this.distanciaRecorrida = distanciaRecorrida;
        this.posicX = posicX;
        this.posicY = posicY;
        this.posicZ = posicZ;
    }

    public Integer getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(Integer distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public Integer getPosicX() {
        return posicX;
    }

    public void setPosicX(Integer posicX) {
        this.posicX = posicX;
    }

    public Integer getPosicY() {
        return posicY;
    }

    public void setPosicY(Integer posicY) {
        this.posicY = posicY;
    }

    public Integer getPosicZ() {
        return posicZ;
    }

    public void setPosicZ(Integer posicZ) {
        this.posicZ = posicZ;
    }

    public NvlResistencia getNvlResistencia() {
        return nvlResistencia;
    }

    public void setNvlResistencia(NvlResistencia nvlResistencia) {
        this.nvlResistencia = nvlResistencia;
    }

    public Colores getColorPrimario() {
        return colorPrimario;
    }

    public void setColorPrimario(Colores colorPrimario) {
        this.colorPrimario = colorPrimario;
    }

    public Colores getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(Colores colorSecundario) {
        this.colorSecundario = colorSecundario;
    }

    public Botas getBotas() {
        return botas;
    }

    public void setBotas(Botas botas) {
        this.botas = botas;
    }

    public Guantes getGuantes() {
        return guantes;
    }

    public void setGuantes(Guantes guantes) {
        this.guantes = guantes;
    }

    public Casco getCasco() {
        return casco;
    }

    public void setCasco(Casco casco) {
        this.casco = casco;
    }

    public Integer getNvlSalud() {
        return nvlSalud;
    }

    public void setNvlSalud(Integer nvlSalud) {
        this.nvlSalud = nvlSalud;
    }

    public Integer getNvlEnergia() {
        return nvlEnergia;
    }

    public void setNvlEnergia(Integer nvlEnergia) {
        this.nvlEnergia = nvlEnergia;
    }

    public Boolean getGenerador() {
        return generador;
    }

    public void setGenerador(Boolean generador) {
        this.generador = generador;
    }

    @Override
    public String toString() {
        return "Armadura{" + "colorPrimario=" + colorPrimario + ", colorSecundario=" + colorSecundario + ", botas=" + botas + ", guantes=" + guantes + ", casco=" + casco + ", nvlSalud=" + nvlSalud + ", nvlEnergia=" + nvlEnergia + ", generador=" + generador + '}';
    }

    public void iniciar(){
        System.out.println("Iniciando sistemas...");
        setColorPrimario(Colores.ROJO);
        setColorSecundario(Colores.DORADO);
        setNvlResistencia(NvlResistencia.HRA);
        setBotas(new Botas(100));
        setGuantes(new Guantes(100));
        setCasco(new Casco("", 100));
        setGenerador(Boolean.TRUE);
        setNvlEnergia(100);
        setNvlSalud(100);
        setPosicX(0);
        setPosicY(0);
        setPosicZ(0);
        setDistanciaRecorrida(0);
    }
    
    public void generadorApagado() {
        switch (getNvlResistencia()) {
            case HRA:
                setNvlSalud(getNvlSalud() + 6);
                if (getNvlSalud() >= 90) {
                    setNvlSalud(100);
                }
                break;
            case HRB:
                setNvlSalud(getNvlSalud() + 10);
                if (getNvlSalud() >= 90) {
                    setNvlSalud(100);
                }
                break;
            case HRC:
                setNvlSalud(getNvlSalud() + 20);
                if (getNvlSalud() >= 90) {
                    setNvlSalud(100);
                }
                break;
        }
    }

    public void recibiendoDanos() {
        switch (getNvlResistencia()) {
            case HRA:
                setNvlSalud(getNvlSalud() - 6);
                break;
            case HRB:
                setNvlSalud(getNvlSalud() - 10);
                break;
            case HRC:
                setNvlSalud(getNvlSalud() - 20);
                break;
        }
    }
    
    public void mostrarEstado() {
        System.out.println("Estado del Mark III\n");
        System.out.println("Salud: " + getNvlSalud());
        System.out.println("Energia");
        System.out.println("Armadura: " + getNvlEnergia() + "\n"
                + "Botas: " + getBotas().getEnergia() + "\n"
                + "Guantes: " + getGuantes().getEnergia() + "\n"
                + "Casco: " + getCasco().getEnergia() + "\n"
                + "Generador: " + getGenerador() + "\n"
                + "Posicion: " + getPosicX() + ", " + getPosicY() + ", " + getPosicZ() + "\n"
                + "Distancia recorrida total: " + getDistanciaRecorrida());
    }

}
