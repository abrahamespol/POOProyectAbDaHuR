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

    public Evaluacion(int idEvalucion, int idMiembroJurado, int idInscripcion, double calificacion, MiembroJurado miembroJurado, Inscripcion inscripcion, int idCriterio, Criterio criterio) {
        this.idEvalucion = Util.nextID("evaluaciones.txt");
        this.idMiembroJurado = idMiembroJurado;
        this.idInscripcion = Util.nextID("inscripciones.txt");
        if(calificacion>=0)
            this.calificacion = calificacion;
        else
            this.calificacion = -calificacion;
        this.miembroJurado = miembroJurado;
        this.inscripcion = inscripcion;
        this.idCriterio = idCriterio;
        this.criterio = criterio;
    }

    public Evaluacion(int idEvalucion, int idMiembroJurado, int idInscripcion, double calificacion, int idCriterio) {
        this.idEvalucion = Util.nextID("evaluaciones.txt");
        this.idMiembroJurado = idMiembroJurado;
        this.idInscripcion = idInscripcion;
        if(calificacion>=0)
            this.calificacion = calificacion;
        else
            this.calificacion = -calificacion;
        this.idCriterio = idCriterio;
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
        if(calificacion>=0)
            this.calificacion = calificacion;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public MiembroJurado getMiembroJurado() {
        return miembroJurado;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setIdEvalucion(int idEvalucion) {
        this.idEvalucion = idEvalucion;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public void setMiembroJurado(MiembroJurado miembroJurado) {
        this.miembroJurado = miembroJurado;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }
    

    @Override
    public String toString() {
        return "Evaluacion{" + "idMiembroJurado=" + idMiembroJurado + ", idInscripcion=" + idInscripcion + ", calificacion=" + calificacion + '}';
    }
    
       public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true )))
        {
            pw.println(this.idEvalucion+"|"+ this.idMiembroJurado+"|"+this.idInscripcion+"|"+this.calificacion+"|"+this.idCriterio);
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
                /* idEvaluacion, idMiembroJurado, idInscripcion, calificacion, idCriterio*/
                String linea=sc.nextLine();
                String [] tokens= linea.split("\\|");
                Evaluacion eva = new Evaluacion(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), Double.parseDouble(tokens[3]), Integer.parseInt(tokens[4]));
                evaluaciones.add(eva);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
  
        }
        return evaluaciones;
    }    
    public static Evaluacion nextEvaluacion(Scanner sc){
        sc.useDelimiter(".");
        String correo;
        do{
            System.out.println("Ingrese el email del jurado: ");
            correo = sc.next();
        }while(MiembroJurado.obtenerMiembroJuradoXEmail(correo) == null);
        int idMiembroJurado = MiembroJurado.obtenerMiembroJuradoXEmail(correo).getId();
        System.out.println("Ingrese el id de la inscripcion: ");
        int idInscripcion = sc.nextInt();
        do{
            System.out.println("Ingrese el id de la inscripcion: ");
            idInscripcion = sc.nextInt();
        }while(Inscripcion.ObtenerObjetoInscripcion(idInscripcion) == null);
        System.out.println("Ingrese el id del criterio: ");
        int idCriterio = sc.nextInt();
        do{
            System.out.println("Ingrese el id del criterio: ");
            idCriterio = sc.nextInt();
        }while(Criterio.ObtenerObjetoCriterio(idCriterio) == null);
        
        System.out.println("Ingrese la nota de evaluacion: ");
        double calificacion = sc.nextDouble();
        Evaluacion eva1= new Evaluacion(Util.nextID("evaluaciones.txt"), idMiembroJurado, idInscripcion,calificacion,idCriterio);
        return eva1;
                
    }            
}