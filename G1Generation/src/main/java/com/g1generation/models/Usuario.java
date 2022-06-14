package com.g1generation.models;

public class Usuario {
    //Atributos
    private String nombre;
    private String apellidos;
    private Integer edad;

    //Constructor vacio
    public Usuario() {
        super();
    }
    //Constructor
    public Usuario(String nombre, String apellidos, Integer edad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }
    //Getter and setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }



}
