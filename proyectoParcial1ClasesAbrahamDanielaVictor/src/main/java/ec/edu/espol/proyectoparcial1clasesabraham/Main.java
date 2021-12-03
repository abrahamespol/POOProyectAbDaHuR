/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham;

import ec.edu.espol.proyectoparcial1clasesabraham.model.Dueño;
import ec.edu.espol.proyectoparcial1clasesabraham.util.Util;
import java.util.Scanner;

/**
 *
 * @author Abraham, Daniela, Victor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Opción 1
        Dueño d1 = new Dueño(9000,"Abraham","Davila","Calle 19","0991377525","aodavila@espol.edu.ec");
        //d1.saveFile("dueños.txt");
        System.out.println(d1);
        Scanner sc = new Scanner(System.in);
        Util.menuOpciones(sc);
        
        //Opción 2
        Util.menuOpciones(sc);
        //Opción 3
        //Opción 4
        //Opción 5
        //Opción 6
        //Opción 7
    }
    
}
