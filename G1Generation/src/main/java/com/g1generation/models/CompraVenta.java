package com.g1generation.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "comprasVentas") // recordar revisar la tabla
public class CompraVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Range(min = 0) // Range - Float, cual es el valor minimo en la escala numerica <> Size la
                    // cantidad de elementos
    private Float monto;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;

    //ManyToOne, quien tenga el Join guardara la FK
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    //ManyToMany AutosVentas
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autos_ventas", // nombre tabla relacional
            joinColumns = @JoinColumn(name = "auto_id"), // desde la identidad donde estamos posicionados
            inverseJoinColumns = @JoinColumn(name = "compra_venta_id")// la otra entidad o tabla
    )
    private List<Auto> autos;

    @Column(updatable= false)
    private Date createdAt;
    private Date updatedAt;
    
    
    public CompraVenta() {
    }


    public CompraVenta(@Range(min = 0) Float monto, Date fecha) {
        this.monto = monto;
        this.fecha = fecha;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Float getMonto() {
        return monto;
    }


    public void setMonto(Float monto) {
        this.monto = monto;
    }


    public Date getFecha() {
        return fecha;
    }


    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    

    public List<Auto> getAutos() {
        return autos;
    }


    public void setAutos(List<Auto> autos) {
        this.autos = autos;
    }


    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }










}
