package com.greyd.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greyd.model.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {
	

}
