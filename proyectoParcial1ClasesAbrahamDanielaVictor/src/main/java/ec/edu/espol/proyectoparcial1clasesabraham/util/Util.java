/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.util;

import ec.edu.espol.proyectoparcial1clasesabraham.model.Dueño;
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
        System.out.println("-- Tiene 8 posibles opciones sobre las que crear registros. -- \n -- Elija con cuidado un NUMERO de opcion, de los dados a continuacion:--\n");
        System.out.println("1: Dueño. 2: Macota. 3: Concurso. 4: Premio. \n5: Criterio. 6: Inscripcion. 7: MiembroJurado. 8: Evaluacion\n");
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
                    System.out.println("Por favor ingrese los datos del Dueño\n");
                    Dueño due = Dueño.nextDueno(sc);
                    due.saveFile("dueños.txt");
                    System.out.println("\n");
                    break;
                    
                case 2:
                    
                    break;
                
                case 3:
                    
                    break;
                
                case 4:
                    System.out.println("Escriba la cantidad de premios a ingresar: \n");
                    int cantidad = sc.nextInt();
                    ArrayList<Premio> awrdsCntst = new ArrayList<>();
                    for(int i = 0 ; i<cantidad; i++){
                        //Hack, parece qur nextPremio no recibe Concurso
                        Premio p = Premio.nextPremio(sc);
                        //añade cada premio en esta lista
                        awrdsCntst.add(p);
                    }
                    int indF = Premio.opcion4(sc);
                    if(indF>=0){
                        for(Premio pri : awrdsCntst){
                            pri.setIdConcurso(indF);
                            pri.saveFile("premios.txt");
                        }
                    }
                    else
                        
                    //aqui se pide el nombre del concurso, se hace set del id del concurso porque esta en default y luego se guardan en el archivo
                    //Luego de setearlos (uno por uno en la listaaa), guardalos en el archivo
                    //puedes hacer esto en nextPremio, tambien puedes pedir el nombre del premio aqui
                    break;

                case 5:
                    
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
