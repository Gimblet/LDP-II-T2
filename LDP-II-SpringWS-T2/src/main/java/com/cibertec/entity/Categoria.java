package com.cibertec.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDE_CAT")
	private Integer idCategoria;
	
	@Column(name = "DES_CAT")
	private String descripcion;
	
	@Column(name = "FRE_COM")
	private String frecuencia;
	
	public Categoria(){
	}
}
