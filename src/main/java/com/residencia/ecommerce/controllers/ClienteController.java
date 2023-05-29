package com.residencia.ecommerce.controllers;

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

import com.residencia.ecommerce.dto.ClienteDTO;
import com.residencia.ecommerce.services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientesDTO() {
        return new ResponseEntity<>(clienteService.getAllClientesDTO(),
                HttpStatus.OK);  
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable Integer id) {
        ClienteDTO clienteResponse = clienteService.getClienteDtoById(id);
        if(null == clienteResponse)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(clienteResponse, HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<ClienteDTO> saveClienteDTO(@RequestBody ClienteDTO clienteDTO) {
        return new ResponseEntity<>(clienteService.saveClienteDTO(clienteDTO),HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<ClienteDTO> updateCliente(@RequestBody ClienteDTO clienteDTO) {
    	if(clienteService.getClienteDtoById(clienteDTO.getIdCliente()) != null) {
            return new ResponseEntity<> (clienteService.updateClienteDTO(clienteDTO),
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<> (clienteDTO,
                    HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delCliente(@PathVariable Integer id) {
        Boolean resp = clienteService.delCliente(id);
        if(resp)
        	return new ResponseEntity<>(resp,HttpStatus.OK);
        else
        	return new ResponseEntity<>(resp,HttpStatus.NOT_MODIFIED);
    }

}


