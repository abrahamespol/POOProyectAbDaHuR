/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.model;

import ec.edu.espol.proyectoparcial1clasesabraham.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Abraham, Daniela, Victor
 */
public class Evaluacion {
    private int idEvalucion;
    private int idMiembroJurado;
    private int idInscripcion;
    private double calificacion;
    private MiembroJurado miembroJurado;
    private Inscripcion inscripcion;
    private int idCriterio;
    private Criterio criterio;

    public Evaluacion(int idEvaluacion, int idMiembroJurado, int idInscripcion, double calificacion, Inscripcion inscripcion, int idCriterio, Criterio criterio) {
        this.idEvalucion = idEvaluacion;
        this.idMiembroJurado = idMiembroJurado;
        this.idInscripcion = idInscripcion;
        this.calificacion = calificacion;
        this.inscripcion = inscripcion;
        this.idCriterio = idCriterio;
        this.criterio = criterio;
    }
    
    

    
        public Evaluacion(int idEvalucion, int idInscripcion,int idMiembroJurado, double calificacion) {
        this.idEvalucion = Util.nextID("evaluaciones.txt");
        this.idInscripcion=Util.nextID("inscripciones.txt");
        this.idMiembroJurado = idMiembroJurado;
        this.calificacion = calificacion;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Evaluacion eva1 = (Evaluacion) obj;
        return (this.idInscripcion == eva1.idInscripcion && this.calificacion== eva1.calificacion);
    }

    public int getIdEvalucion() {
        return idEvalucion;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Evaluacion{" + "idMiembroJurado=" + idMiembroJurado + ", idInscripcion=" + idInscripcion + ", calificacion=" + calificacion + '}';
    }
    
       public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true )))
        {
            pw.println(this.idEvalucion+"|"+ this.idMiembroJurado+"|"+ this.calificacion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
  
        }
    }
   public static ArrayList<Evaluacion> readFile(String nomfile){
        ArrayList<Evaluacion> evaluaciones= new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea=sc.nextLine();
                String [] tokens= linea.split("|");
                Evaluacion eva = new Evaluacion(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]));
                evaluaciones.add(eva);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
  
        }
        return evaluaciones;
    }    
    public static Evaluacion nextEvaluacion(Scanner sc){
        System.out.println("Ingrese el nombre del Miembro del Jurado: ");
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        String nombreJurado=sc.next();
        System.out.println("Ingrese la calificacion");
        double nota=sc.nextDouble();
        Evaluacion new_eva= new Evaluacion(Util.nextID("evaluaciones.txt"),/*Colocar el valor del id de la inscripcion buscada de acuerdo al nombre del concurso*/ ,MiembroJurado.obtenerMiembroJuradoXNombre(nombreJurado),/*Colocar el */ ,nota);
        
        return new_eva;
    }
    
    }