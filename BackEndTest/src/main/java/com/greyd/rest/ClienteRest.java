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

import com.greyd.dao.ClienteDAO;
import com.greyd.model.Cliente;

@RestController
@RequestMapping("clients")
public class ClienteRest {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	
	//SERVER REQUESTS
	
	@PostMapping("/save")
	public void save(@RequestBody Cliente cliente)
	{
		clienteDAO.save(cliente);
	}
	
	@GetMapping("/list")
	public List<Cliente> list()
	{
		return clienteDAO.findAll();
	}
	
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") Integer id)
	{
		clienteDAO.deleteById(id);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Cliente cliente)
	{
		clienteDAO.save(cliente);
	}
	

	
	

}
