/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.model;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Abraham, Daniela, Victor
 */
public class Criterio {
    private int idCriterio;
    private String nombre;
    private String descripcion;
    private double puntajeMax;
    private ArrayList<Evaluacion> evaluaciones;
    private int idEvaluacion;
    private int idConcurso;
    private Concurso concursos;

    public Criterio(int idCriterio, String nombre, String descripcion, double puntajeMax, ArrayList<Evaluacion> evaluaciones, int idEvaluacion, int idConcurso, Concurso concursos) {
        this.idCriterio = idCriterio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntajeMax = puntajeMax;
        this.evaluaciones = new ArrayList<> ();
        this.idEvaluacion = idEvaluacion;
        this.idConcurso = idConcurso;
        this.concursos = concursos;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPuntajeMax() {
        return puntajeMax;
    }

    public ArrayList<Evaluacion> getEvaluaciones() {
        return evaluaciones;
    }

    public int getIdEvaluacion() {
        return idEvaluacion;
    }

    public int getIdConcurso() {
        return idConcurso;
    }

    public Concurso getConcursos() {
        return concursos;
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

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public void setIdConcurso(int idConcurso) {
        this.idConcurso = idConcurso;
    }

    public void setConcursos(Concurso concursos) {
        this.concursos = concursos;
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
        final Criterio other = (Criterio) obj;
        if (this.idCriterio != other.idCriterio) {
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
        sb.append("Criterio No. " + this.idCriterio +"\n Nombre del criterio: "+ this.nombre+ "\n Descripcion: " + this.descripcion+ "\n Puntaje máximo: "+this.puntajeMax);
        sb.append("Concurso No. " + this.idConcurso + "\n Nombre del concurso: " + concursos.getNombre()+"\n Fecha: " + concursos.getFecha() +"/n Fecha de Inscripción: " + concursos.getFechaInscripcion() + "/n Fecha de cierre de Inscripción: " + concursos.getFechaCierreInscripcion()+ "/n Temática: " + concursos.getTematica() + "/n Costo: " + concursos.getCosto());
        for(Evaluacion evaluacion : evaluaciones)
            sb.append("Evaluaciones No. "+this.idEvaluacion+"\n Calificacion: "+evaluacion.getCalificacion());
        return sb.toString();
    }
}
