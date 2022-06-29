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
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
public class Auto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String marca;
	private String modelo;
	private Float velocidad;
	private String color;
	private Float valor;

	//ManyToMany AutosVentas
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autos_ventas", // nombre tabla relacional
            joinColumns = @JoinColumn(name = "auto_id"), // desde la identidad donde estamos posicionados = Auto
            inverseJoinColumns = @JoinColumn(name = "compra_venta_id")// la otra entidad o tabla = CompraVenta
    )
	private List<CompraVenta> compraVentas;

	@Column(updatable = false)
	private Date createdAt;

	private Date updatedAt;

	public Auto() {
	}

	

	public Auto(String marca, String modelo, Float velocidad, String color, Float valor) {
		this.marca = marca;
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.color = color;
		this.valor = valor;
	}

	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public Float getVelocidad() {
		return velocidad;
	}



	public void setVelocidad(Float velocidad) {
		this.velocidad = velocidad;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public Float getValor() {
		return valor;
	}



	public void setValor(Float valor) {
		this.valor = valor;
	}



	public List<CompraVenta> getCompraVentas() {
		return compraVentas;
	}



	public void setCompraVentas(List<CompraVenta> compraVentas) {
		this.compraVentas = compraVentas;
	}



	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();

	}
}
