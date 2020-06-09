package com.company.colegio;

import com.google.gson.*;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Colegio {

    private ArrayList<Alumnos> alumnos;
    public Set<String> nacionalidades=new HashSet<String>();
    private int count;

    public Colegio(){
        this.alumnos=new ArrayList<Alumnos>();
    }

    public void mostrarAlumnos(){
        for (Alumnos alumno : alumnos){
            System.out.println(alumno.toString());
        }
    }

    public void agregarAlumno(Alumnos alumno){
        try{
            if(alumno.getNombre().isEmpty() || alumno.getNacionalidad().toString().isEmpty()){
                throw new IllegalArgumentException();
            }else{
                alumnos.add(alumno);
                nacionalidades.add(alumno.getNacionalidad().toString());
            }
        }catch (IllegalArgumentException excepcion){
            excepcion.printStackTrace();
        }
    }

    public void verNacionalidad(String nacionalidad){
        count = 0;
        for (Alumnos alumno : alumnos){
            if (alumno.getNacionalidad().toString().equals(nacionalidad)){
                count++;
            }
        }
        System.out.println("Nacionalidad: " + nacionalidad + " Cantidad de alumnos: " + count);
    }

    public void cuantos(){
        System.out.println("Hay " + nacionalidades.size() + " nacionalidades");
    }

    public void borrarAlumno(Alumnos alumno){
        boolean isAlumno=false;
        try {
            for (Alumnos a : alumnos) {
                if (a.getNombre().equals(alumno.getNombre()) && a.getNacionalidad().equals(alumno.getNacionalidad())) {
                    isAlumno = true;
                }
            }
            if (isAlumno) {
                alumnos.remove(alumno);
                System.out.println("Alumno eliminado.");
            } else {
                throw new IllegalArgumentException();
            }
        }catch (IllegalArgumentException excepcion) {
            excepcion.printStackTrace();
        }
    }

    public void verTodos(){
        for(String nacionalidad : nacionalidades){
            verNacionalidad(nacionalidad);
        }
    }

    public void crearArchivoAlumnos(File archivoAlumnos){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(archivoAlumnos));

            if (archivoAlumnos.canWrite()){
                for (Alumnos alumno : alumnos){
                    bw.write(alumno.toString() + "\n");
                }
            }
            bw.close();
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void leerArchivoAlumnos(File archivoAlumnos){
        if (archivoAlumnos.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(archivoAlumnos));
                String alumno=null;
                if (archivoAlumnos.canRead()){
                    while ((alumno=br.readLine()) != null){
                        System.out.println(alumno);
                    }
                }
                br.close();
            }catch (IOException excepcion){
                excepcion.printStackTrace();
            }
        }
    }


    public void crearArchivoJSON(File archivoAlumnos){
        try{
            BufferedWriter bw=new BufferedWriter(new FileWriter(archivoAlumnos));
            Gson gson=new Gson();
            gson.toJson(alumnos, ArrayList.class, bw);
            bw.close();
        }catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void leerArchivoJSON(File archivoAlumnos){
        if (archivoAlumnos.exists()) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(archivoAlumnos));

                Gson gson=new Gson();

                JsonParser parser =  new JsonParser();
                JsonElement jsonElement = parser.parse(br); //esto retorna un jsonElement leido del buffer
                JsonArray array = jsonElement.getAsJsonArray();
                //System.out.println(array);

                for (JsonElement element : array){
                    Alumnos alumno=gson.fromJson(element.getAsJsonObject(), Alumnos.class);
                    System.out.println(alumno.toString());
                }

                /**IMPRIME EL ARCHIVO JSON COMO STRING*/
//                JsonElement element= gson.fromJson(br, JsonElement.class);
//                String resultado= gson.toJson(element);
//                System.out.println(resultado);

                br.close();
            }catch (IOException excepcion){
                excepcion.printStackTrace();
            }
        }
    }

}





