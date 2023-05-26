package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.dto.CategoriaDTO;
import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<CategoriaDTO> getAllCategorias() {
		List<Categoria> categorias = categoriaRepository.findAll();
				
		List<CategoriaDTO> listaCategoriaDto = new ArrayList<>();
		for (Categoria categoria: categorias) {
			CategoriaDTO categoriaDto = modelMapper.map(categoria, CategoriaDTO.class);
			listaCategoriaDto.add(categoriaDto);
		}
		
		return listaCategoriaDto;
	}
	
	

}
