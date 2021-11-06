package com.example.wsapi.service;

import java.util.List;

import com.example.wsapi.entity.Producto;

public interface ProductoService {
	
	List<Producto> readAll();
	Producto read(int id);
	Producto create(Producto producto);
	Producto update(Producto producto);
	void delete(int id);

}
