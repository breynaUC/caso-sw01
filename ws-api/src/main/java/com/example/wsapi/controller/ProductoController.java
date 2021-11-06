package com.example.wsapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wsapi.entity.Producto;
import com.example.wsapi.service.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	

	
	@GetMapping("/all")
	public ResponseEntity<List<Producto>> getProducto(){
		try {
			List<Producto> lista = new ArrayList<>();
			lista = productoService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProducto(@PathVariable("id") int id){
		Producto p = productoService.read(id);
		if(p.getId()>0) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			productoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/create")
	public ResponseEntity<Producto> save(@RequestBody Producto prod){
		try {
			Producto p = new Producto();
			p.setNombre(prod.getNombre());
			p.setPrecio(prod.getPrecio());
			p.setStock(prod.getStock());
			Producto pro = productoService.create(p);
			return new ResponseEntity<>(pro, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto prod, @PathVariable("id") int id){
		try {
			Producto p = productoService.read(id);
			if(p.getId()>0) {
				p.setNombre(prod.getNombre());
				p.setPrecio(prod.getPrecio());
				p.setStock(prod.getStock());
				return new ResponseEntity<>(productoService.create(p),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
