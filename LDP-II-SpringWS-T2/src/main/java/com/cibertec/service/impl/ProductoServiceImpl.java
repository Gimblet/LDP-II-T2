package com.cibertec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.entity.Producto;
import com.cibertec.repository.ProductoRepository;
import com.cibertec.service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	@Autowired
	ProductoRepository repo;

	@Override
	public List<Producto> getAllProducto() {
		return repo.findAll();
	}

	@Override
	public Producto updateProducto(Producto userEntity) {
		return repo.save(userEntity);
	}

	@Override
	public Producto findProductoById(Integer id) {
		return repo.findById(id).get();
	}

}
