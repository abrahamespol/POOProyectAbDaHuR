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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;


/**
 *
 * @author Lenovo
 */
public class Concurso {

    private int idConcurso;
    private String nombre;
    private LocalDateTime fecha;
    private Date fechaInscripcion;
    private Date fechaCierreInscripcion;
    private String tematica;
    private ArrayList<Inscripcion> inscripcion;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterio;
    
    
    public Concurso(int idConcurso, String nombre, Date fecha, Date fechaInscripcion, Date fechaCierreInscripcion, String tematica) {
        this.idConcurso = idConcurso;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.tematica = tematica;        
    }
    
    

    public Concurso(int idConcurso, String nombre, Date fecha, Date fechaInscripcion, Date fechaCierreInscripcion, String tematica, ArrayList<Inscripcion> inscripcion, ArrayList<Premio> premios, ArrayList<Criterio> criterio) {
        this.idConcurso = idConcurso;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.tematica = tematica;
        this.inscripcion = new ArrayList<> ();
        this.premios = new ArrayList<> ();
        this.criterio = new ArrayList<> ();
    }

    public int getIdConcurso() {
        return this.idConcurso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public Date getFechaInscripcion() {
        return this.fechaInscripcion;
    }

    public Date getFechaCierreInscripcion() {
        return this.fechaCierreInscripcion;
    }

    public String getTematica() {
        return this.tematica;
    }

    public ArrayList<Inscripcion> getInscripcion() {
        return this.inscripcion;
    }

    public ArrayList<Premio> getPremios() {
        return this.premios;
    }

    public ArrayList<Criterio> getCriterio() {
        return this.criterio;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setFechaInscripcion(Date fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public void setFechaCierreInscripcion(Date fechaCierreInscripcion) {
        this.fechaCierreInscripcion = fechaCierreInscripcion;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public void setInscripcion(ArrayList<Inscripcion> inscripcion) {
        this.inscripcion = inscripcion;
    }

    public void setPremios(ArrayList<Premio> premios) {
        this.premios = premios;
    }

    public void setCriterio(ArrayList<Criterio> criterio) {
        this.criterio = criterio;
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
        Concurso co = (Concurso) obj;
        return this.idConcurso == co.idConcurso && Objects.equals(this.nombre, co.nombre);
    }

   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Concurso No. " + this.idConcurso + "\n Nombre del concurso: " + this.nombre+"\n Fecha: " + this.fecha +"/n Fecha de Inscripción: " + this.fechaInscripcion + "/n Fecha de cierre de Inscripción: " + this.fechaCierreInscripcion+ "/n Temática: " + this.tematica + "/n Costo: " + this.costo);
        for(Inscripcion ins : inscripcion)
            sb.append("\n Mascota"+ins.getMascota()+"\n Descuento: "+ins.getDescuento()+"\n Valor a pagar:"+ins.getValor());
        
        for(Premio premio : premios)
            sb.append("\n El premio: "+ premio.getDescripcion() + " está destinado para el "+ premio.getPuesto() +"lugar. \n");
        
        for(Criterio crit: criterio)
            sb.append("Criterio No.: " + crit.getIdCriterio() + "/n Descripción: " + crit.getDescripcion() + "\n Puntaje máximo: "+ crit.getPuntajeMax());
        
        return sb.toString();
    }
    //métodos
    
     public void saveFile(String nomFile){ 
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile)))){
            pw.println(Util.nextID(nomFile)+ "|" + this.nombre+"|" + this.fecha +"|" + this.fechaInscripcion + "|" + this.fechaCierreInscripcion+ "|" + this.tematica + "|" + this.costo);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Concurso> readFromFile(String nomFile){
        ArrayList<Concurso> concurso = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");// revisar video
                Concurso con = new Concurso(Integer.parseInt(tokens[0]),tokens[1],(tokens[2]),(tokens[3]),(tokens[4]),tokens[5]);
                concurso.add(con);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return concurso;
    }
    
    public static Concurso nextConcurso(Scanner sc){
        int idc = Util.nextID("concursos.txt");
        System.out.println("Ingrese el nombre del concurso: ");
        String name = sc.next();//no sé porque pusiste el next y después el nextLine porque podía solo poner el next line y ya, pero lo pongo por si acaso
        String name1 = sc.nextLine();
        System.out.println("Ingrese la fecha del concurso: ");
        String f = sc.next();
        LocalDateTime dateC = LocalDateTime.parse(f);
        System.out.println("Ingrese la fecha de incripción del concurso en este orden año,mes,día: ");
        Date fi = sc.nextDate();//Tengo que ver un video del ayudante donde explica lo de las fechas porque no me acuerdo
        System.out.println("Ingrese la fecha de cierre de incripción del consurso: ");
        Date fc = sc.nextDate(); //Tengo que ver un video del ayudante donde explica lo de las fechas porque no me acuerdo
        System.out.println("Ingrese la temática del concurso: ");
        String tm = sc.nextLine();
        Concurso con = new Concurso(idc, name1, dateC, fi, fc,tm);
        return con;
    }

    public static Concurso obtenerConcursoXNombre(Scanner sc){
        ArrayList<Concurso> concursos = Concurso.readFromFile("concursos.txt");
        sc.useDelimiter("\n");
        System.out.println("Ingrese el nombre del Concurso al que pertenecen sus premios: ");
        String nombreP = sc.next();
        for(Concurso c : concursos){
            if(Objects.equals(c.nombre,nombreP))
                 return c;   
        }
        return null;
    }        
    
}
