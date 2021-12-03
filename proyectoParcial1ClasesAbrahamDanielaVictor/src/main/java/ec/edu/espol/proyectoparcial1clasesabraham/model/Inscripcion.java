/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espol.proyectoparcial1clasesabraham.model;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Victor Zuñiga
 */
public class Inscripcion {
    private int id;
    private int idMascota;
    private Mascota mascota;
    private int idConcurso;
    private Concurso concurso;
    private double costoInscripcion;
    private double descuento;
    private ArrayList<Evaluacion> evaluaciones;
    private ArrayList<Inscripcion> incripciones;
    private Date fecha;
    
//    public Inscripcion(Scanner String, Scanner String2){
//        
//        Scanner sc= new Scanner(System.in);
//        String nombreConcurso= sc.next();
//        System.out.println("Ingrese el valor a pagar");
//        this.costoInscripcion = sc.nextDouble();
//        try {
//            
//            System.out.println("Introduzca la fecha de incripcion con formato dd/mm/yyyy");
//            SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
//            this.fecha= formato.parse(sc.next());
//        } catch (ParseException ex) {
//            Logger.getLogger(Inscripcion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        this.evaluaciones=new ArrayList<>();
//        this.incripciones=new ArrayList<>();
//    }
    public void saveFile(String nomfile){
        try(PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomfile),true )))
        {
            pw.println(this.idMascota+","+concurso.getIdConcurso()+","+this.fecha+","+this.costoInscripcion);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
  
        }
    }

    @Override
    public String toString() {
        return "Inscripcion" + this.idMascota+","+concurso.getIdConcurso()+","+this.fecha+","+this.costoInscripcion ;
    }
    
    
}
