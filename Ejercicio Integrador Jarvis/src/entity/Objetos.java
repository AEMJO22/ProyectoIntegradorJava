/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;

import enums.NvlResistencia;


public class Objetos {

    
    private Boolean hostil;
    private String nombre;
    private NvlResistencia nvlResis;
    private Integer salud;
    
    private Integer posicX;
    private Integer posicY;
    private Integer posicZ;

    public Objetos() {
    }

    public Objetos(Boolean hostil, String nombre, NvlResistencia nvlResis, Integer salud, Integer posicX, Integer posicY, Integer posicZ) {
        this.hostil = hostil;
        this.nombre = nombre;
        this.nvlResis = nvlResis;
        this.salud = salud;
        this.posicX = posicX;
        this.posicY = posicY;
        this.posicZ = posicZ;
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

    public Integer getSalud() {
        return salud;
    }

    public void setSalud(Integer salud) {
        this.salud = salud;
    }
    
    public NvlResistencia getNvlResis() {
        return nvlResis;
    }

    public void setNvlResis(NvlResistencia nvlResis) {
        this.nvlResis = nvlResis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getHostil() {
        return hostil;
    }

    public void setHostil(Boolean hostil) {
        this.hostil = hostil;
    }

    @Override
    public String toString() {
        return "Objetos{" + "hostil=" + hostil + ", nombre=" + nombre + ", nvlResis=" + nvlResis + ", salud=" + salud + ", X=" + posicX + ", Y=" + posicY + ", Z=" + posicZ + '}';
    }

    public void daniosEnemigos() {
        switch (getNvlResis()) {
            case HRA:
                if (getSalud() < 50) {
                    setSalud(0);
                    break;
                }
                setSalud(getSalud() - 33);
                break;
            case HRB:
                setSalud(getSalud() - 50);
                break;
            case HRC:
                setSalud(getSalud() - 50);
                break;
        }
    }
    
}
