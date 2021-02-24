package com.greyd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyd.model.Factura;

public interface FacturaDAO extends JpaRepository<Factura, Integer>{

}
