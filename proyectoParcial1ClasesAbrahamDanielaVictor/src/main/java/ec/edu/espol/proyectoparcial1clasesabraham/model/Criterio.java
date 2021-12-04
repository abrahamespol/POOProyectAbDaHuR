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
import java.util.Objects;
import java.util.Scanner;


/**
 *
 * @author Lenovo
 */
public class Criterio {
    private int idCriterio;
    private String nombre;
    private String descripcion;
    private double puntajeMax;
    private ArrayList<Evaluacion> evaluaciones;
    //private int idEvaluacion;
    private int idConcurso;
    private Concurso concursos;
    
    
     public Criterio(int idCriterio,int idConcurso, String nombre, String descripcion, double puntajeMax) {
        this.idCriterio = idCriterio;
        this.idConcurso = idConcurso;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntajeMax = puntajeMax;
       
    }
    

    public Criterio(int idCriterio, String nombre, String descripcion, double puntajeMax, ArrayList<Evaluacion> evaluaciones,/* int idEvaluacion, */int idConcurso, Concurso concursos) {
        this.idCriterio = idCriterio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntajeMax = puntajeMax;
        this.evaluaciones = new ArrayList<> ();
//        this.idEvaluacion = idEvaluacion;
        this.idConcurso = idConcurso;
        this.concursos = concursos;
    }

    public int getIdCriterio() {
        return this.idCriterio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public double getPuntajeMax() {
        return this.puntajeMax;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return this.evaluaciones;
    }

//    public int getIdEvaluacion() {
//        return this.idEvaluacion;
//    }

    public int getIdConcurso() {
        return this.idConcurso;
    }

    public Concurso getConcursos() {
        return this.concursos;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPuntajeMax(double puntajeMax) {
        this.puntajeMax = puntajeMax;
    }

    public void setEvaluaciones(ArrayList<Evaluacion> evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

//    public void setIdEvaluacion(int idEvaluacion) {
//        this.idEvaluacion = idEvaluacion;
//    }
//
    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setConcursos(Concurso concursos) {
        this.concursos = concursos;
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
        Criterio crto = (Criterio) obj;
        return this.idCriterio == crto.idCriterio && Objects.equals(this.nombre, crto.nombre);
    }

    

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("Criterio No. " + this.idCriterio +"\n Nombre del criterio: "+ this.nombre+ "\n Descripcion: " + this.descripcion+ "\n Puntaje máximo: "+this.puntajeMax);
        sb.append("Concurso No. " + this.idConcurso + "\n Nombre del concurso: " + concursos.getNombre()+"\n Fecha: " + concursos.getFecha() +"/n Fecha de Inscripción: " + concursos.getFechaInscripcion() + "/n Fecha de cierre de Inscripción: " + concursos.getFechaCierreInscripcion()+ "/n Temática: " + concursos.getTematica());
        for(Evaluacion evaluacion : evaluaciones)
            //sb.append("Evaluaciones No. "+this.idEvaluacion+"\n Calificacion: "+evaluacion.getNota());
            sb.append("Calificacion de evaluacion: "+evaluacion.getCalificacion());
        return sb.toString();
    }
    
    
    public void saveFile(String nomFile){ 
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile)))){
            pw.println(Util.nextID(nomFile)+"|"+this.idConcurso+"|"+this.nombre+"|"+this.descripcion+"|"+this.puntajeMax);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Criterio> readFromFile(String nomFile){
        ArrayList<Criterio> criterio = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Criterio cr = new Criterio(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), tokens[2],tokens[3],Double.parseDouble(tokens[4]));
                criterio.add(cr);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return criterio;
    }
    
    public static Criterio nextCriterio(Scanner sc){
        int idcr = Util.nextID("criterios.txt");
        int idc = 0;
        System.out.println("Ingrese el nombre del criterio: ");
        String name = sc.next();
        String namec = sc.nextLine();
        System.out.println("Ingrese la descripción del criterio: ");
        String dp = sc.nextLine();
        System.out.println("Ingrese el puntaje máximo: ");
        Double pm = sc.nextDouble();
        Criterio cr1 = new Criterio(idcr,idc, namec, dp, pm);
        return cr1;
    }
        public static Criterio obtenerCriterioXNombre(String nombre){
        ArrayList<Criterio> criterios = Criterio.readFromFile("criterios.txt");
        for(Criterio msc : criterios){
            if(Objects.equals(msc.nombre, nombre))
                 return msc;   
        }
        return null;
    }  
    
    public static Criterio ObtenerObjetoCriterio(int id){    
        ArrayList<Criterio> list_criterios=Criterio.readFromFile("criterios.txt");
        for ( Criterio criterio:list_criterios){
            if(criterio.getIdCriterio() == id){
                return criterio;   
            }
        }return null;
        
    }

}

