package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cibertec.entity.Inventario;
import com.cibertec.service.InventarioService;
import com.cibertec.service.ProductoService;

import org.springframework.ui.Model;

@Controller
public class InventarioController {

	@Autowired
	private InventarioService inventarioSrv;

	@Autowired
	private ProductoService productoSrv;

	@GetMapping("/")
	public String listaInventarios(Model model) {
		model.addAttribute("inventarios", inventarioSrv.getAllInventario());
		model.addAttribute("productos", productoSrv.getAllProducto());

		return "index";
	}

	@GetMapping("/inventario/edit/{id}")
	public String preUpdateInventario(@PathVariable Integer id, Model model) {
		Inventario inventario = inventarioSrv.findInventarioById(id);
		model.addAttribute("inventario", inventario);
		model.addAttribute("ListaProductos", productoSrv.getAllProducto());

		return "inventario/edit";
	}

	@PostMapping("/inventario/{id}")
	public String updateInventario(@PathVariable Integer id, @ModelAttribute("inventario") Inventario inventario,
			Model model) {
		Inventario item = inventarioSrv.findInventarioById(id);
		item.setNumeroInventario(id);
		item.setFecha(inventario.getFecha());
		item.setIdProducto(inventario.getIdProducto());
		item.setCostoIngreso(inventario.getCostoIngreso());
		inventarioSrv.updateInventario(item);

		return "redirect:/";
	}

}
