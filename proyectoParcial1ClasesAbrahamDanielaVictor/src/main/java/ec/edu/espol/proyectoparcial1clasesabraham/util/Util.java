/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.util;

import ec.edu.espol.proyectoparcial1clasesabraham.model.Concurso;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Criterio;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Dueño;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Mascota;
import ec.edu.espol.proyectoparcial1clasesabraham.model.MiembroJurado;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Premio;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author eduardo
 */
public class Util {
    
    // el constructor se lo ha declarado privado
    // ya que esta clase solo va a contener comportamientos estáticos
    // por lo tanto, no se van a permitir crear instancia de la clase Util
    private Util(){}
    
    public static int nextID(String nomfile)
    {
        int id = 0;
        try(Scanner sc = new Scanner(new File(nomfile)))
        {
           while(sc.hasNextLine())
           {
               String linea = sc.nextLine();
               String[] tokens = linea.split("\\|");
               id = Integer.parseInt(tokens[0]);
           }
        }
        catch(Exception e)
        {
        }
        return id+1;
    }
    //Menu
    public static void menuOpciones(Scanner sc){ 
        //codigo
        System.out.println("-- Gracias por Ingresar al menú de opciones --\n");
        System.out.println("-- Tiene 8 posibles opciones sobre las que crear registros. -- \n-- Elija con cuidado un NUMERO de opcion, de los dados a continuacion:--\n");
        System.out.println("1: Dueño. \n2: Macota. \n3: Concurso. \n4: Premio. \n5: Criterio. \n6: Inscripcion. \n7: MiembroJurado. \n8: Evaluacion\n");
        int infNGTV = (int)Double.NEGATIVE_INFINITY;
        int infPSTV = (int)Double.POSITIVE_INFINITY;
        int opcion;
        do{
            do{
                System.out.println("Escriba un numero de opcion\n");
                opcion = sc.nextInt();
            }while(opcion < 1 || opcion > 8);
            switch(opcion){
                case 1:
                    System.out.println("Por favor ingrese los datos del Dueño: \n");
                    Dueño due = Dueño.nextDueno(sc);
                    due.saveFile("dueños.txt");
                    System.out.println("\n");
                    break;
                    
                case 2:
                    System.out.println("Por favor ingrese los datos de la Mascota\n");
                    Mascota mascota1 = Mascota.nextMascota(sc);
                    int indD = 0;
                    do{
                        indD = Mascota.opcion2(sc);
                    }while(indD<0);
                    mascota1.setIdDueño(indD);
                    mascota1.saveFile("mascotas.txt");
                    break;
                
                case 3:
                    
                    System.out.println("Por favor ingrese los datos del Concurso: \n");
                    Concurso concurso1 = Concurso.nextConcurso(sc);
                    concurso1.saveFile("concursos.txt");
                    System.out.println("\n");
                    break;
                
                case 4:
                    System.out.println("Escriba la cantidad de premios a ingresar: \n");
                    int cantidad = sc.nextInt();
                    ArrayList<Premio> awrdsCntst = new ArrayList<>();
                    for(int i = 0 ; i<cantidad; i++){
                        Premio p = Premio.nextPremio(sc);
                        //añade cada premio en esta lista
                        awrdsCntst.add(p);
                    }
                    int indP = 0;
                    do{
                        indP = Premio.opcion4(sc);
                    }while(indP<0);
                    for(Premio pri : awrdsCntst){
                            pri.setIdConcurso(indP);
                            pri.saveFile("premios.txt");
                    }   
                    break;

                case 5:
                    
                    System.out.println("Escriba la cantidad de criterios a ingresar: \n");
                    int cant = sc.nextInt();
                    ArrayList<Criterio> lst_crit = new ArrayList<>();
                    for(int i = 0 ; i<cant; i++){
                        Criterio c = Criterio.nextCriterio(sc);
                        lst_crit.add(c);
                    }
                    int indC = Criterio.opcion5(sc);
                    if(indC>=0){
                        for(Criterio crit : lst_crit){
                            crit.setIdConcurso(indC);
                            crit.saveFile("criterios.txt");
                        }
                    }
                    else
                    
                    break;
                
                case 6:
                    
                    break;
                
                case 7:
                    System.out.println("Por favor ingrese los datos del Miembro del Jurado\n");
                    MiembroJurado mbjr = MiembroJurado.nextMiembroJurado(sc);
                    mbjr.saveFile("miembroJurados.txt");
                    System.out.println("\n");
                    break;
                
                case 8:
                    
                    break;
            }
        }while(opcion > infNGTV && opcion < infPSTV);
    }
}
