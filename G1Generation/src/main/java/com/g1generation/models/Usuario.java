package com.g1generation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity // nuestro objeto se va a convertir en una entidad
@Table(name = "usuarios") // nombre que vamos a trabajar en la base de datos

public class Usuario {
    // Atributos
    @Id // estas columnas siempre las vamos a ocupar para todos los objetos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20) // vamos a controlar cuantos caracteres, ingresara el cliente
    private String nombre;
    @Size(min = 3, max = 20)
    private String apellidos;

    private Integer edad;
    @NotNull
    @Size(min = 6, max = 8)
    private String password;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Licencia licencia;

    // ManyToMany
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_usuarios", // nombre tabla relacional
            joinColumns = @JoinColumn(name = "usuario_id"), // desde la identidad donde estamos posicionados
            inverseJoinColumns = @JoinColumn(name = "rol_id")// la otra entidad o tabla
    )
    private List<Rol> roles;

    // Constructor vacio
    public Usuario() {
        super();
    }

    // Constructor
    public Usuario(String nombre, String apellidos, Integer edad, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.password = password;
    }
    // Getter and setters
    // Tomar valores y ponerlos

    public Long getId() {
        return id;
    }

    public Licencia getLicencia() {
        return licencia;
    }

    public void setLicencia(Licencia licencia) {
        this.licencia = licencia;
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

}
