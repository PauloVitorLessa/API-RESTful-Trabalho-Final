package com.residencia.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.dto.RoleDTO;
import com.residencia.ecommerce.services.RoleService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	RoleService roleService;
	
	@PostMapping
	public ResponseEntity<RoleDTO> save(@Valid @RequestBody RoleDTO roleDTO) {
		RoleDTO newRole = roleService.saveRoleDTO(roleDTO);
		if(newRole != null)
			return new ResponseEntity<>(newRole, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(newRole, HttpStatus.BAD_REQUEST);
	}
	
	

}