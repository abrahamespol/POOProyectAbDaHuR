/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Abraham, Daniela, Victor
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

    public Mascota(int idMascota, String nombre, String raza, Date fechaNacimiento, String tipo, int idDueño, Dueño dueño, ArrayList<Inscripcion> inscripciones) {
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
        return idMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRaza() {
        return raza;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getTipo() {
        return tipo;
    }

    public int getIdDueño() {
        return idDueño;
    }

    public Dueño getDueño() {
        return dueño;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
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

        return this.idMascota == other.idMascota && this.idDueño == other.idDueño && Objects.equals(this.nombre, other.nombre);
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Macota No. " + this.idMascota + "\n Nombre de la mascota: " + this.nombre+"\n Tipo de animal: " + this.tipo +"/n Raza de la mascota: " + this.raza + "/n Fecha de nacimiento: " + this.fechaNacimiento+ "Pertenece a /n"+ "Id de Dueño: "+dueño.getIddueño+"/n Nombre: "+dueño.getNombre+", Apellidos: "+ dueño.getApellido);
        for(Inscripcion inscripcion : inscripciones)
            sb.append("\n Costo de la inscripcion: "+inscripcion.getCostoInscripcion+"/n Fecha de inscripción: "+inscripcion.getFechaInscripcion);
        return sb.toString();
    }
    
    public void saveFile(String nomfile){ 
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile)))){
            pw.println(this.idMascota+"|"+this.nombre+"|"+this.raza+"|"+this.fechaNacimiento+"|"+this.tipo);
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }    
}
