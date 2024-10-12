package com.cibertec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cibertec.entity.Producto;
import com.cibertec.service.CategoriaService;
import com.cibertec.service.ProductoService;

@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoSrv;
	
	@Autowired
	private CategoriaService categoriaSrc;

	@GetMapping("/producto/")
	public String listaProductos(Model model) {
		model.addAttribute("productos", productoSrv.getAllProducto());
		model.addAttribute("categorias", categoriaSrc.getAllCategoria());

		return "producto/index";
	}

	@GetMapping("/producto/edit/{id}")
	public String preUpdateProducto(@PathVariable Integer id, Model model) {
		Producto producto = productoSrv.findProductoById(id);
		model.addAttribute("producto", producto);
		model.addAttribute("ListaCategorias", categoriaSrc.getAllCategoria());

		return "producto/edit";
	}

	@PostMapping("/producto/{id}")
	public String updateInventario(@PathVariable Integer id, @ModelAttribute("producto") Producto producto, Model model) {
		Producto item = productoSrv.findProductoById(id);
		item.setIdProducto(id);
		item.setNombre(producto.getNombre());
		item.setIdCategoria(producto.getIdCategoria());
		item.setStockActual(producto.getStockActual());
		
		productoSrv.updateProducto(item);

		return "redirect:/producto/";
	}
}
