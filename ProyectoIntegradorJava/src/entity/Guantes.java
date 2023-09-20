/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;


public class Guantes {

    private Integer energia;

    public Guantes() {
    }

    public Guantes(Integer energia) {
        this.energia = energia;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "GuanteIzq{" + "energia=" + energia + '}';
    }
}
