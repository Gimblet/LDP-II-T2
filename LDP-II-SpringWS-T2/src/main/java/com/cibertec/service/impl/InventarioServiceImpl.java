package com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Inventario;
import com.cibertec.repository.InventarioRepository;
import com.cibertec.service.InventarioService;

@Service
public class InventarioServiceImpl implements InventarioService {
	
	@Autowired
	InventarioRepository repo;

	@Override
	public List<Inventario> getAllInventario() {
		return repo.findAll();
	}

	@Override
	public Inventario updateInventario(Inventario userEntity) {
		return repo.save(userEntity);
	}

	@Override
	public Inventario findInventarioById(Integer id) {
		return repo.findById(id).get();
	}

}
