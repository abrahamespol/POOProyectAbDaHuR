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
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Abraham, Daniela, Victor
 */
public class MiembroJurado extends Persona{
    //Parte del distintivo personal podría ser el perfil profesional, o la lista de evaluaciones
    private String descripcionPerfilProfesional;
    private ArrayList<Evaluacion> evaluaciones;
    //
    
    
    //Constructores
    
    public MiembroJurado(int id, String nombre, String apellidos, String telefono,
            String email, String perfilProfesional) {
        super(id, nombre, apellidos, telefono, email);
        this.descripcionPerfilProfesional = perfilProfesional;
        this.evaluaciones = new ArrayList<>();
    }
    
    //Getters no heredados

    public String getDescripcionPerfilProfesional() {
        return descripcionPerfilProfesional;
    }

    //Setters no Heredados (la lista de evaluaciones puede ser editada por indice, en lugar de cambiada)
    
    public void setDescricpcionPerfilProfesional(String perfilProfesional){
        this.descripcionPerfilProfesional = perfilProfesional;
    }
    
    //toString sobreescrito 
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Miembro de jurado: "+this.nombre+' '+this.apellidos+" cuyo id y perfil profesional son "
                +this.id+' '+this.descripcionPerfilProfesional+" tiene las siguientes evaluaciones: ");
        for(Evaluacion ev : this.evaluaciones){
            sb.append(ev+". \n");
        }
        return sb.toString();
    }
    
    //equals NO necesita sobreescribirse ( solo se usa el que se hereda )
    
    
    //Guardar objetos en archivos
    
    @Override
    public void saveFile(String nomFile){
        try (PrintWriter pw = new PrintWriter(new FileOutputStream(new File(nomFile),true))){
            pw.println(Util.nextID(nomFile)+"|"+this.nombre+"|"+this.apellidos+
                    "|"+this.telefono+"|"+this.email+"|"+this.descripcionPerfilProfesional);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    
    public static ArrayList<MiembroJurado> readFromFile(String nomFile){
        ArrayList<MiembroJurado> mjrs = new ArrayList<>();
        try(Scanner sc = new Scanner(new File(nomFile))){
            while(sc.hasNextLine()){
                String linea = sc.nextLine();
                String[] tokens = linea.split("\\|");
                MiembroJurado mjr = new MiembroJurado(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                mjrs.add(mjr);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return mjrs;
    }
    
    //Pedir objeto por Scanner, AQUI NO SE PERMITE QUE EL USUARIO INGRESE EL ID DE MIEMBROJURADO, sino que se lo ingresa por medio de nextID    
    //MUY IMPORTANTE: como cada objeto se guarda en un archivo, el ID depende de cuantos objetos esten guardados en este
    //Por lo que al usar esta funcion, se meten un Scanner (para que el usuario llene los valores), y el nombre del archivo
    //A pesar de que no se guarden objetos en ese lugar (Recuerda hacerle esas preguntas al profesor)
    public static MiembroJurado nextMiembroJurado(Scanner sc){
        sc.useDelimiter("\n");
        int idm = Util.nextID("miembroJurados.txt");
        System.out.println("Ingrese el nombre del Miembro del Jurado: ");
        String nb0 = sc.next();
        String nombre = nb0.toUpperCase().charAt(0) + nb0.substring(1, nb0.length()).toLowerCase();      
        System.out.println("Ingrese los apellidos del Miembro del Jurado");
        String ap = sc.next();
        String apellido = ap.toUpperCase().charAt(0) + ap.substring(1, ap.length()).toLowerCase();
        System.out.println("Ingrese el numero de telefono del Miembro de Jurado: ");
        String tlf = sc.next();
        System.out.println("Ingrese el email del Miembro del Jurado: ");
        String mail = sc.next().toLowerCase();
        System.out.println("Ingrese la descripcion profesional de su Miembro de Jurado: ");
        String descrp = sc.next().toLowerCase();
        MiembroJurado mj = new MiembroJurado(idm, nombre, apellido, tlf, mail, descrp);
        return mj;
    }
        public static MiembroJurado obtenerMiembroJuradoXEmail(String email1){
        ArrayList<MiembroJurado> jueces = MiembroJurado.readFromFile("miembroJurados.txt");
        for(MiembroJurado miembro: jueces){
            if(Objects.equals(miembro.email,email1))
                 return miembro;   
        }
        return null;
    }
//        public static MiembroJurado obtenerMiembroJuradoXNombre(Scanner sc){
//        ArrayList<MiembroJurado> jueces = MiembroJurado.readFromFile("miembroJurados.txt");
//        sc.useDelimiter("\n");
//        System.out.println("Ingrese el nombre del Miembro del Jurado que realiza la evaluacion: ");
//        String nombre1= sc.next();
//        for(MiembroJurado miembro: jueces){
//            if(Objects.equals(miembro.nombre,nombre1))
//                 return miembro;   
//        }
//        return null;
//    }        
        
}
