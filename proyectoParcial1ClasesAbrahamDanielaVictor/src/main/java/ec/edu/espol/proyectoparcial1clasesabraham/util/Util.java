/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.util;

import ec.edu.espol.proyectoparcial1clasesabraham.model.Concurso;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Criterio;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Dueño;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Inscripcion;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Mascota;
import ec.edu.espol.proyectoparcial1clasesabraham.model.MiembroJurado;
import ec.edu.espol.proyectoparcial1clasesabraham.model.Premio;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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
                    Dueño dueno;
                    int idD = 0;
                    do{
                        dueno = Dueño.obtenerDueñoXEmail(sc);
                    }while(dueno == null);
                    idD = dueno.getId();
                    mascota1.setIdDueño(idD);
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
                    int idC = 0;
                    Concurso conc;
                    do{
                        conc = Concurso.obtenerConcursoXNombre(sc); 
                    }while(conc == null);
                    idC = conc.getIdConcurso();
                    for(Premio p: awrdsCntst){
                        p.setIdConcurso(idC);
                        p.saveFile("premios.txt");
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
                    int indC = 0;
                    Concurso con;
                    do{
                        con =  Concurso.obtenerConcursoXNombre(sc); 
                    }while(con == null);
                    indC = con.getIdConcurso();                    
                    for(Criterio crit: lst_crit){
                        crit.setIdConcurso(indC);
                        crit.saveFile("criterios.txt");
                    }
                    break;
                    
                case 6:
                    sc.useDelimiter("\n");
                    Inscripcion inscp = Inscripcion.nextInscripcion(sc);  
                    inscp.saveFile("inscripciones.txt");                  
//                    int indMc = 0;
//                    Mascota msc = null;
//                    do{
//                        msc =  Mascota.obtenerMascotaXNombre(sc); 
//                    }while(msc == null);
//                    indMc = msc.getIdMascota();
//                    int idCo = 0;
//                    Concurso conco = null;
//                    do{
//                        conco =  Concurso.obtenerConcursoXNombre(sc); 
//                    }while(conco == null);
//                    idCo = conco.getIdConcurso();
//                    System.out.println("Ingrese el costo de la Inscripcion: ");
//                    double costoI = sc.nextDouble();
//                    System.out.println("Ingrese Fecha de Inscripcion: ");
//                    Implementacion de ingreso de fecha, AGREGAR
//                    Guardar Inscripcion en su archivo "inscripciones.txt" usando los datos indMc e idCo (idMascota e idConcurso segun el nombre ingresado de c/u)
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
