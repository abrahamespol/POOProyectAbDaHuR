/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Abraham, Daniela, Victor
 */
public class Concurso {
    private int idConcurso;
    private String nombre;
    private Date fecha;
    private Date fechaInscripcion;
    private Date fechaCierreInscripcion;
    private String tematica;
    private double costo;
    private ArrayList<Inscripcion> inscripcion;
    private ArrayList<Premio> premios;
    private ArrayList<Criterio> criterio;

    public Concurso(int idConcurso, String nombre, Date fecha, Date fechaInscripcion, Date fechaCierreInscripcion, String tematica, double costo, ArrayList<Inscripcion> inscripcion, ArrayList<Premio> premios, ArrayList<Criterio> criterio) {
        this.idConcurso = idConcurso;
        this.nombre = nombre;
        this.fecha = fecha;
        this.fechaInscripcion = fechaInscripcion;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.tematica = tematica;
        this.costo = costo;
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

    public double getCosto() {
        return this.costo;
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

    public void setCosto(double costo) {
        this.costo = costo;
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
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Concurso other = (Concurso) obj;
        if (this.idConcurso != other.idConcurso) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

   

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Concurso No. " + this.idConcurso + "\n Nombre del concurso: " + this.nombre+"\n Fecha: " + this.fecha +"/n Fecha de Inscripción: " + this.fechaInscripcion + "/n Fecha de cierre de Inscripción: " + this.fechaCierreInscripcion+ "/n Temática: " + this.tematica + "/n Costo: " + this.costo);
        for(Inscripcion ins : inscripcion)
            sb.append("\n Mascota"+ins.getMascota()+"\n Descuento: "+ins.getDescuento()+"\n Valos a pagar:"+ins.getValor());
        
        for(Premio premio : premios)
            sb.append("\n El premio: "+ premio.getDescripcion() + " está destinado para el "+ premio.getPuesto() +"lugar. \n");
        
        for(Criterio crit: criterio)
            sb.append("Criterio No.: " + crit.getIdCriterio() + "/n Descripción: " + crit.getDescripcion() + "\n Puntaje máximo: "+ crit.getPuntajeMax());
        
        return sb.toString();
    }    

}
