package com.example.wsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wsapi.entity.Producto;
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
