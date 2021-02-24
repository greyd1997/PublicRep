package com.greyd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyd.model.Producto;

public interface ProductoDAO extends JpaRepository<Producto, Integer>{

}
