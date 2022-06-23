package com.g1generation.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="licencias")
public class Licencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private Integer numero;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaVencimiento;
    private String clase;
    private String estado;

    // opcionales, sirven para la gestion de la base de datos
    // esta columna en especifico nunca se actualizara por medio del sistema
    @Column(updatable= false)
    private Date createdAt;

    private Date updatedAt;
    //private Date deletedAt; //fecha de eliminacion logica

    //Relaciones OneToOne (1a1) -- 
    @OneToOne(fetch=FetchType.LAZY)
    //LAZY --> Trae todas relaciones pero las muestra cuando nosotros la consultamos 
    //EAGER --> Trae todas las relaciones y las muestra enseguida

    @JoinColumn(name="usuario_id") // Esta seria una FOREING KEY (FK) de Usuario y la PRIMARY KEY (PK) de Licencia
    private Usuario usuario;



    // Constructor vacio
    public Licencia() {
    }

    // Constructor
    public Licencia(Long id, Integer numero, Date fechaVencimiento, String clase, String estado, Date createdAt) {
        
        this.id = id;
        this.numero = numero;
        this.fechaVencimiento = fechaVencimiento;
        this.clase = clase;
        this.estado = estado;
        
    }

    //Getters and setters

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    //Insertara el atributo, la fecha antes de insertar en la base de datos
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


    }

    
    
    

