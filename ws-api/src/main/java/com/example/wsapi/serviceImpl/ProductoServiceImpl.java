package com.example.wsapi.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wsapi.entity.Producto;
import com.example.wsapi.repository.ProductoRepository;
import com.example.wsapi.service.ProductoService;
@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository productoRepository;
	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productoRepository.findAll();
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id).get();
	}

	@Override
	public Producto create(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Producto update(Producto producto) {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

}
