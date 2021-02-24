package com.greyd.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greyd.dao.ProductoDAO;
import com.greyd.model.Producto;


@RestController
@RequestMapping("products")
public class ProductoRest {

	@Autowired
	private ProductoDAO productoDAO;
	
	//SERVER REQUESTS
	@PostMapping("/save")
	public void save(@RequestBody Producto producto)
	{
		productoDAO.save(producto);
	}
	
	@GetMapping("/list")
	public List<Producto> list()
	{
		return productoDAO.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id)
	{
		productoDAO.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Producto producto)
	{
		productoDAO.save(producto);
	}
	
}
