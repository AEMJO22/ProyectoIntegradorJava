 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.Objetos;
import enums.NvlResistencia;
import java.util.ArrayList;
import java.util.Random;

public class RadarImplementService {

    public ArrayList<Objetos> pulsoRadar() {
        System.out.println("----------Pulso Radar----------");
        String letra = "A";
        ArrayList<Objetos> objetos = new ArrayList();
        Random random = new Random();
        int cantidad = (int) (Math.random() * 10);
        for (int i = 0; i < cantidad; i++) {
            int nvlResis = random.nextInt(NvlResistencia.values().length);
            objetos.add(new Objetos(random.nextBoolean(), letra.concat(String.valueOf(i)), NvlResistencia.values()[nvlResis], 100, (int) (Math.random() * 1000), (int) (Math.random() * 1000), (int) (Math.random() * 1000)));
        }
        return objetos;
    }

    public Integer distancia(Integer x1, Integer y1, Integer z1, Integer x2, Integer y2, Integer z2) {
        Integer x3, y3, z3;
        x3 = 0 - x1 - 0 - x2;
        x3 = (int) (Math.pow(x3, 2));
        y3 = 0 - y1 - 0 - y2;
        y3 = (int) (Math.pow(y3, 2));
        z3 = 0 - z1 - 0 - z2;
        z3 = (int) (Math.pow(z3, 2));
        return (int) (Math.sqrt(x3 + y3 + z3));
    }
}
