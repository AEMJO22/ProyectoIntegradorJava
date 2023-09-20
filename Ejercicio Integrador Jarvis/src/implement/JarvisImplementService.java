/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implement;

import entity.Armadura;
import entity.Objetos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JarvisImplementService {

    AccionesImplementService accServ = new AccionesImplementService();
    RadarImplementService radServ = new RadarImplementService();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public void menu() throws IOException {
        System.out.println("Bienvenido");
        Armadura mark3 = new Armadura();
        mark3.iniciar();
        System.out.println("Mark III iniciado correctamente");
        mark3.mostrarEstado();
        start(mark3);
    }

    public void start(Armadura mark3) throws IOException {
        boolean bandera = false;
        int aux = 0, i = 0;
        String opcion;
        ArrayList<Objetos> objetos = new ArrayList();
        do {
            if (i == 0) {
                objetos = radServ.pulsoRadar();
            }
            System.out.println("Radar activado");
            System.out.println("Numero de hostiles: " + hostiles(objetos)+"\n");
            switch (opcionJarvis()) {
                case 1:
                    mark3.setDistanciaRecorrida(accServ.caminar(mark3) + mark3.getDistanciaRecorrida());
                    if (hostiles(objetos) == 0) {
                        objetos = radServ.pulsoRadar();
                    }
                    break;
                case 2:
                    mark3.setDistanciaRecorrida(accServ.correr(mark3) + mark3.getDistanciaRecorrida());
                    if (hostiles(objetos) == 0) {
                        objetos = radServ.pulsoRadar();
                    }
                    break;
                case 3:
                    mark3.setDistanciaRecorrida(accServ.propulsar(mark3) + mark3.getDistanciaRecorrida());
                    if (hostiles(objetos) == 0) {
                        objetos = radServ.pulsoRadar();
                    }
                    break;
                case 4:
                    mark3.setDistanciaRecorrida(accServ.volar(mark3) + mark3.getDistanciaRecorrida());
                    if (hostiles(objetos) == 0) {
                        objetos = radServ.pulsoRadar();
                    }
                    break;
                case 5:
                    accServ.disparar(mark3, objetos);
                    break;
                case 6:
                    System.out.println(accServ.consejo());
                    break;
                case 7:
                    String objetivo = null;
                    System.out.println("¿Deseas buscar un enemigo en particular?");
                    opcion = br.readLine();
                    if (opcion.equalsIgnoreCase("si")) {
                        System.out.println("Nombre del objetivo ej(a1)");
                        objetivo = br.readLine();
                        accServ.consultarDistancia(objetivo, objetos, mark3);
                    } else {
                        accServ.consultarDistancia(objetivo, objetos, mark3);
                    }
                    break;
                case 8:
                    System.out.println("Escapando..");
                    bandera = true;
                    break;
                case 9:
                    mark3.setGenerador(Boolean.FALSE);
                    break;
                case 10:
                    mark3.setGenerador(Boolean.TRUE);
            }

            //Luego de acciones
            i++;
            if (0 == i % 2) {
                if (aux == mark3.getDistanciaRecorrida()) {
                    mark3.recibiendoDanos();
                }
                ataqueEnemigo(objetos, mark3);
                if (mark3.getGenerador()) {
                    mark3.recibiendoDanos();
                }
            }
            if (mark3.getGenerador()) {
                mark3.setNvlEnergia(100);
                mark3.getBotas().setEnergia(100);
                mark3.getGuantes().setEnergia(100);
            } else if (!mark3.getGenerador()) {
                mark3.generadorApagado();
            }
            mark3.mostrarEstado();
            aux = mark3.getDistanciaRecorrida();
        } while (mark3.getNvlSalud() > 0 && !bandera);
    }

    public void ataqueEnemigo(ArrayList<Objetos> objetos, Armadura mark3) {
        int ataque;
        for (Objetos objeto : objetos) {
            if (objeto.getHostil()) {
                ataque = (int) (Math.random() * 100);
                if (ataque <= 20) {
                    mark3.recibiendoDanos();
                }
            }
        }
    }

    public Integer hostiles(ArrayList<Objetos> objetos) {
        int hostiles = 0;
        for (Objetos objeto : objetos) {
            if (objeto.getHostil()) {
                hostiles++;
            }
        }
        return hostiles;
    }

    public Integer opcionJarvis() throws IOException {
        Integer opcion = 0;
        do {
            System.out.println("Opciones Jarvis:");
            System.out.println("1: Caminar.\n"
                    + "2: Correr.\n"
                    + "3: Propulsarse.\n"
                    + "4: Volar.\n"
                    + "5: Disparar.\n"
                    + "6: Esperar.\n"
                    + "7: Consultar distancia de hostiles o eliminar si se encuentran fuera de alcance(requiere nombre del objetivo).\n"
                    + "8: Escapar.\n"
                    + "9: Apagar generador\n"
                    + "10: Encender generador.\n");
            try {
                opcion = Integer.parseInt(br.readLine());
                if (opcion < 1 || opcion > 9) {
                    System.out.println("\nOpcion no disponible\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error en el tipo de dato ingresado.");
            }
        } while (opcion < 1 || opcion > 9);
        return opcion;
    }
    
}
