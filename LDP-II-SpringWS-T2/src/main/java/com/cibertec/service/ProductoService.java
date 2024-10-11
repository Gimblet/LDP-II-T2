package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Producto;

public interface ProductoService {
	public List<Producto> getAllProducto();
	
	public Producto updateProducto(Producto userEntity);
	
	public Producto findProductoById(Integer id);
}
