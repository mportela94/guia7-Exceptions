package com.company;

import com.company.colegio.Alumnos;
import com.company.colegio.Colegio;
import com.company.colegio.Nacionalidad;
import com.company.guessNumber.Game;
import com.company.guessNumber.RandomNumber;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /**EJERCICIO 3*/
        /*
        Game juego = new Game();
        while (juego.getHit() == false){
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nIngrese un numero:");
            String string=scanner.nextLine();
            juego.userAttempt(string);
        }
        System.out.println("\nFelicitaciones, ganaste el juego, el numero era: " + juego.getNumber());
        System.out.println("\nCantidad de intentos: " + juego.getIntentos());
        */

        /**EJERCICIO 4**/
        Alumnos alumno=new Alumnos("Matias Portela", Nacionalidad.ARGENTINA);
        Alumnos alumno2=new Alumnos("Juan Perez", Nacionalidad.ARGENTINA);
        Alumnos alumno3=new Alumnos("Tommy Jones", Nacionalidad.ESTADOUNIDENSE);
        Alumnos alumno4=new Alumnos("Sebastian Lopez", Nacionalidad.URUGUAYA);
        Alumnos alumno5=new Alumnos("Santiago Alvarez", Nacionalidad.CHILENA);
        Alumnos alumno6=new Alumnos("Pablo Irigoyen", Nacionalidad.ARGENTINA);
        Alumnos alumno7=new Alumnos("Roberto Leuco", Nacionalidad.URUGUAYA);
        Alumnos alumno8=new Alumnos();

        Colegio colegio=new Colegio();
        colegio.agregarAlumno(alumno);
        colegio.agregarAlumno(alumno5);
        colegio.agregarAlumno(alumno3);
        colegio.agregarAlumno(alumno7);


        System.out.println("------------------------------------");
        colegio.verNacionalidad(Nacionalidad.ARGENTINA.toString());
        System.out.println("------------------------------------");
        colegio.cuantos();
        System.out.println("------------------------------------");
        colegio.mostrarAlumnos();
        System.out.println("");
        colegio.borrarAlumno(alumno7);  //encuentra y borra
        System.out.println("");
        colegio.mostrarAlumnos();
        //colegio.borrarAlumno(alumno2);  //no lo encuentra y tira el exception
        System.out.println("------------------------------------");
        colegio.verTodos();
        System.out.println("------------------------------------");

        System.out.println("ARCHIVOS");
        File archivoAlumnos= new File("alumnos.txt");

        colegio.crearArchivoAlumnos(archivoAlumnos);
        System.out.println("Lectura de Archivo");
        colegio.leerArchivoAlumnos(archivoAlumnos);
    }

}
