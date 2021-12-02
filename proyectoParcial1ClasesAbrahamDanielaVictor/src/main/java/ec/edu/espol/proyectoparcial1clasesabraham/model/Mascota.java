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
public class Mascota {
    private int idMascota;
    private String nombre;
    private String raza;
    private Date fechaNacimiento;
    private String tipo;
    private int idDueño;
    private Dueño dueño;
    private ArrayList<Inscripcion> inscripciones;
    
     public Mascota(int idMascota,int idDueño, String nombre, String tipo, String raza, Date fechaNacimiento) {
        this.idMascota = idMascota;
        this.idDueño = idDueño;
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
    }

    public Mascota(int idMascota, String nombre, String tipo, String raza, Date fechaNacimiento, int idDueño, Dueño dueño, ArrayList<Inscripcion> inscripciones) {
        this.idMascota = idMascota;
        this.nombre = nombre;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.tipo = tipo;
        this.idDueño = idDueño;
        this.dueño = dueño;
        this.inscripciones = new ArrayList<> ();
    }

    public int getIdMascota() {
        return this.idMascota;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getRaza() {
        return this.raza;
    }

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getIdDueño() {
        return this.idDueño;
    }

    public Dueño getDueño() {
        return this.dueño;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return this.inscripciones;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setIdDueño(int idDueño) {
        this.idDueño = idDueño;
    }

    public void setDueño(Dueño dueño) {
        this.dueño = dueño;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mascota other = (Mascota) obj;
        return (this.idMascota != other.idMascota && this.idDueño != other.idDueño && !Objects.equals(this.nombre, other.nombre) );
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Macota No. " + this.idMascota + "\n Nombre de la mascota: " + this.nombre+"\n Tipo de animal: " + this.tipo +"/n Raza de la mascota: " + this.raza + "/n Fecha de nacimiento: " + this.fechaNacimiento+ "Pertenece a /n"+ "Id de Dueño: "+dueño.getIddueño+"/n Nombre: "+dueño.getNombre+", Apellidos: "+ dueño.getApellido);
        for(Inscripcion inscripcion : inscripciones)
            sb.append("\n Costo de la inscripcion: "+inscripcion.getCostoInscripcion+"/n Fecha de inscripción: "+inscripcion.getFechaInscripcion);
        return sb.toString();
    }
    
    public void saveFile(String nomFile){ 
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile)))){
            pw.println(Util.nextID(nomFile)+"|"+this.idDueño+"|"+this.nombre+"|"+this.tipo+"|"+this.raza+"|"+this.fechaNacimiento);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public static ArrayList<Mascota> readFromFile(String nomFile){
        ArrayList<Mascota> mascota = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                Mascota mas = new Mascota(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), tokens[2],tokens[3],tokens[4],(tokens[5]));
                mascota.add(mas);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        return mascota;
    }
    
    public static Mascota nextMascota(Scanner sc){
        int idm = Util.nextID("mascotas.txt");
        int idD = 0;
        System.out.println("Ingrese el nombre de la mascota: ");
        String name = sc.next();
        String name1 = sc.nextLine();
        System.out.println("Ingrese el tipo de mascota: ");
        String tip = sc.nextLine();
        System.out.println("Ingrese la raza de su mascota: ");
        String raz = sc.nextLine();
        System.out.println("Ingrese la fecha de nacimiento de su mascota: ");
        Date fechaNac = sc.nextDate(); //Tengo que ver un video del ayudante donde explica lo de las fechas porque no me acuerdo
        Mascota mas1 = new Mascota(idm,idD, name1, tip, raz, fechaNac);
        return mas1;
    }
    
    //Metodo para sacar el email del dueño
    
    public static int opcion2(Scanner sc){
        System.out.println("Por favor ingrese el email del dueño de la mascota: \n");
        String em = sc.nextLine();
        int indiD = 0;
        ArrayList<Dueño> dueños = Dueño.readFromFile("dueños.txt");
        for(Dueño d : dueños){
            if(Objects.equals(d.getEmail(),em)){
                indiD = dueños.indexOf(d);
                return indiD;
            }
        }
        return -1;
    }
    
            
    
    
}
