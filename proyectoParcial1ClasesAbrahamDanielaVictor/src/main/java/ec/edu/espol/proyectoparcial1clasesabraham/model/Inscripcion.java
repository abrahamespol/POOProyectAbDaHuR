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
import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Victor Zuñiga
 */
public class Inscripcion {
    private int idInscripcion;
    private int idMascota;
    private Mascota mascota;
    private int idConcurso; 
    private Concurso concurso;
    private LocalDate fechaInscripcion;  
    private double costoInscripcion;
    private ArrayList<Evaluacion> evaluaciones;
    private double descuento;
    /*  idInscripcion, idConcurso, fecha, costo */

    public Inscripcion(int idInscripcion,int idMascota, int idConcurso, LocalDate fechaInscripcion, double costoInscripcion) {
        this.idInscripcion = idInscripcion;
        this.idConcurso = idConcurso;
        this.fechaInscripcion = fechaInscripcion;
        this.costoInscripcion = costoInscripcion;
        this.idMascota= idMascota;
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
        Inscripcion new_ins = (Inscripcion) obj;
        return (this.idInscripcion == new_ins.idInscripcion);
    }

    public int getIdInscripcion() {
        return idInscripcion;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(LocalDate fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public double getCostoInscripcion() { 
        return costoInscripcion;
    }

    public void setCostoInscripcion(double costoInscripcion) {
        this.costoInscripcion=costoInscripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        if(this.costoInscripcion>25.0)
        this.descuento = this.costoInscripcion-this.costoInscripcion*0.1;
        else{
            this.descuento=0.0;
        }
    }
    
    
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true )))
        {
            pw.println(this.idInscripcion+"|"+this.idMascota+"|"+ this.idConcurso+"|"+ this.fechaInscripcion+"|"+this.costoInscripcion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
       public static ArrayList<Inscripcion> readFromFile(String nomfile){
        ArrayList<Inscripcion> inscripciones = new ArrayList<>();
        try(Scanner sc= new Scanner(new File(nomfile))){
            while(sc.hasNextLine())
            {
                String linea=sc.nextLine();
                String [] tokens= linea.split("|");
                Inscripcion insc = new Inscripcion(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]), LocalDate.parse(tokens[3]), Double.parseDouble(tokens[4]));
                inscripciones.add(insc);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
  
        }
        return inscripciones;
       }
    
    
    public static Inscripcion nextInscripcion(Scanner sc){
        System.out.println("Ingrese el nombre de la mascota: ");
        sc.useDelimiter("\n");
        sc.useLocale(Locale.US);
        String nombre_mascota = sc.next();
        System.out.println("Ingrese el nombre del concurso: ");
        sc.useDelimiter("\n");
        String nombre_concurso = sc.next();
        System.out.println("Ingrese la fecha de inscripcion en el formato: año,mes,dia");
        sc.useDelimiter(",");
        LocalDate fecha = LocalDate.parse(sc.next());
        System.out.println("Ingrese el costo de inscripcion: ");
        double costo = sc.nextDouble();
        Inscripcion new_inscrip = new Inscripcion(Util.nextID("inscripciones.txt"),Mascota.obtenerMascotaXNombre(nombre_mascota).getIdMascota(),Concurso.obtenerConcursoXNombre(nombre_concurso).getIdConcurso(),fecha,costo);
        return new_inscrip;
    }
    

}
