package com.cibertec.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NRO_INV")
	private Integer numeroInventario;
	
	@Column(name = "FEC_INV")
	private Date fecha;
	
	@JoinColumn(name = "IDE_PRO")
	@ManyToOne
	private Producto idProducto;
	
	@Column(name = "COS_ING")
	private double costoIngreso;
	
	public Inventario() {
	}
}
