package com.company.colegio;

import java.util.ArrayList;

public class Alumnos {

  private String nombre;
  private Nacionalidad nacionalidad;

  public Alumnos(){
  }

  public Alumnos(String nombre, Nacionalidad nacionalidad){
      this.nombre=nombre;
      this.nacionalidad=nacionalidad;
  }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    @Override
    public String toString(){
      return ("Alumno: " + nombre + " - Nacionalidad: " + nacionalidad);
    }
}
