/*

 */

package entity;


public class Casco {

    private String sintentizador;
    private Integer energia;

    public Casco() {
    }

    public Casco(String sintentizador, Integer energia) {
        this.sintentizador = sintentizador;
        this.energia = energia;
    }

    public String getSintentizador() {
        return sintentizador;
    }

    public void setSintentizador(String sintentizador) {
        this.sintentizador = sintentizador;
    }

    public Integer getEnergia() {
        return energia;
    }

    public void setEnergia(Integer energia) {
        this.energia = energia;
    }

    @Override
    public String toString() {
        return "Casco{" + "sintentizador=" + sintentizador + ", energia=" + energia + '}';
    }
    
    
}
