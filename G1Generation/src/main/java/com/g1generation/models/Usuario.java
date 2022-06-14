package com.g1generation.models;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity// nuestro objeto se va a convertir en una entidad
@Table(name="usuarios") //nombre que vamos a trabajar en la base de datos

public class Usuario {
    //Atributos
    @Id // estas columnas siempre las vamos a ocupar para todos los objetos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20) //vamos a controlar cuantos caracteres, ingresara el cliente
    private String nombre;
    @Size(min = 3, max = 20)
    private String apellidos;

    private Integer edad;
    @NotNull
    @Size(min = 6, max = 8)
    private String password;

    //Constructor vacio
    public Usuario() {
        super();
    }
    //Constructor
    public Usuario(String nombre, String apellidos, Integer edad, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.password = password;
    }
    //Getter and setters
    // Tomar valores y ponerlos

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
