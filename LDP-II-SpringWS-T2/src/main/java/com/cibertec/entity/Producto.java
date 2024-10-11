package com.cibertec.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "productos")
public class Producto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "IDE_PRO")
	private Integer idProducto;
	
	@Column(name = "NOM_PRO")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name = "IDE_CAT")
	@Column(name = "IDE_CAT")
	private Integer idCategoria;
	
	@Column(name = "STK_ACT")
	private int stockActual;
	
	public Producto() {
	}

}
