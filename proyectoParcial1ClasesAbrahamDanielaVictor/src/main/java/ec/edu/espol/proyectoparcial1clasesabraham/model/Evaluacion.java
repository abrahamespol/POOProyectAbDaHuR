/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 *
 * @author Abraham, Daniela, Victor
 */
public class Evaluacion {
    private int id;
    private Inscripcion idInscripcion;
    private Inscripcion inscripcion;
    private int idMiembroJurado;
    private double nota;
    private int idCriterio;
    private Criterio criterio;

    public Evaluacion(Inscripcion idInscripcion, int idCriterio) {
        this.idInscripcion = idInscripcion;
        this.idCriterio = idCriterio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inscripcion getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Inscripcion idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Inscripcion getInscripcion() {
        return inscripcion;
    }

    public void setInscripcion(Inscripcion inscripcion) {
        this.inscripcion = inscripcion;
    }

    public int getIdMiembroJurado() {
        return idMiembroJurado;
    }

    public void setIdMiembroJurado(int idMiembroJurado) {
        this.idMiembroJurado = idMiembroJurado;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdCriterio() {
        return idCriterio;
    }

    public void setIdCriterio(int idCriterio) {
        this.idCriterio = idCriterio;
    }

    public Criterio getCriterio() {
        return criterio;
    }

    public void setCriterio(Criterio criterio) {
        this.criterio = criterio;
    }
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true )))
        {
            pw.println(jurado.getEmail()+","+MiembroJurado.getEmail()+","+this.id,this.idCriterio+","+this.nota);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        }

    @Override
    public String toString() {
        return "Evaluacion{" + "id=" + id + ", idInscripcion=" + idInscripcion + ", inscripcion=" + inscripcion + ", idMiembroJurado=" + idMiembroJurado + ", nota=" + nota + ", idCriterio=" + idCriterio + ", criterio=" + criterio + '}';
    }
        
}
