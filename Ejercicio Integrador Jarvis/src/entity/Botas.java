/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entity;


public class Botas {

    private Integer energia;

    public Botas() {
    }

    public Botas(Integer energia) {
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
        return "BotaIzq{" + "energia=" + energia + '}';
    }
}
