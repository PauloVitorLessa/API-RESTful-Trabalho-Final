package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> getAllClientes() {
		List<Cliente> clientes = clienteRepository.findAll();
				
		return clientes;
	}
	
	public Cliente getClienteById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		
		if(cliente==null)
			return null;
		
		return cliente;
		
	}
	
	public Cliente saveCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
		 
	}
	
	public Cliente updateCliente(Cliente cliente) {
	
		return clienteRepository.save(cliente);
		
		
	}
	
	public Boolean delCliente(Integer id) {
		if(clienteRepository.findById(id).orElse(null)!=null) {
			  clienteRepository.deleteById(id);
		 if(clienteRepository.findById(id).orElse(null)==null)
			 return true;
		  else
		     return false;
		}
		 else return false;
	    	  
	}
}