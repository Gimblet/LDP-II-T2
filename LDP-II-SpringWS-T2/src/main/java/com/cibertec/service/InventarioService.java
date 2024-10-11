package com.cibertec.service;

import java.util.List;

import com.cibertec.entity.Inventario;

public interface InventarioService {
	public List<Inventario> getAllInventario();
	
	public Inventario updateInventario(Inventario userEntity);
	
	public Inventario findInventarioById(Integer id);
}
