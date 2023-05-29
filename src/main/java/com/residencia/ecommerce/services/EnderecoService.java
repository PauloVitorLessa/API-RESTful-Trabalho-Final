package com.residencia.ecommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.dto.EnderecoDTO;
import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.exceptions.CustomException;
import com.residencia.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	ModelMapper modelMapper;
	
	public List<EnderecoDTO> getAllEnderecosDTO() {		
		List<Endereco> listaEndereco = enderecoRepository.findAll();
		List<EnderecoDTO> listaEnderecoDTO = listaEndereco.stream().map(x -> new EnderecoDTO(x)).toList();					
		return listaEnderecoDTO;
	}
	
	public EnderecoDTO getEnderecoDtoById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id).orElse(null);		
		if(endereco==null)
			return null;		
		EnderecoDTO enderecoDTO = modelMapper.map(endereco, EnderecoDTO.class);		
		return enderecoDTO;		
	}
	
	public EnderecoDTO saveEnderecoDTO(EnderecoDTO enderecoDTO) {
		Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
		Endereco saveEnderecoResponse = enderecoRepository.save(endereco);
		if(saveEnderecoResponse == null) {
			throw new CustomException("Erro ao salvar no banco");
		}
		
		return modelMapper.map(saveEnderecoResponse, EnderecoDTO.class);		 
	}
	
	public EnderecoDTO updateEnderecoDTO(EnderecoDTO enderecoDTO) {
	
		Endereco endereco = modelMapper.map(enderecoDTO, Endereco.class);
		Endereco saveEnderecoResponse = enderecoRepository.save(endereco);
		return modelMapper.map(saveEnderecoResponse, EnderecoDTO.class);		
	}
	
	   public Boolean delEndereco(Integer id) {
		  if(enderecoRepository.findById(id).orElse(null)!=null) {
			  enderecoRepository.deleteById(id);
			  if(enderecoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	    	  
	      }
}
