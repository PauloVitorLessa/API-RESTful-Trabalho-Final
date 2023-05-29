package com.residencia.ecommerce.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.dto.ProdutoDTO;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.exceptions.CustomException;
import com.residencia.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	public List<ProdutoDTO> getAllProdutosDTO() {
		List<Produto> produtos = produtoRepository.findAll();
		List<ProdutoDTO> listaProdutoDTO = produtos.stream().map(x -> new ProdutoDTO(x)).toList();						
		return listaProdutoDTO;
	}
	
	public ProdutoDTO getProdutoDtoById(Integer id) {
		Produto produto = produtoRepository.findById(id).orElse(null);		
		if(produto==null)
			return null;		
		ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);		
		return produtoDTO;		
	}
	
	public ProdutoDTO saveProdutoDTO(ProdutoDTO produtoDTO) {	
		Produto produto = modelMapper.map(produtoDTO, Produto.class);	
		Produto saveProdResponse =  produtoRepository.save(produto);
		
		if(saveProdResponse == null) {
			throw new CustomException("Erro ao salvar no banco");
		}
		
		return modelMapper.map(saveProdResponse, ProdutoDTO.class);		 
	}
	
	public ProdutoDTO updateProdutoDTO(ProdutoDTO produtoDTO) {
	
		Produto produto = modelMapper.map(produtoDTO, Produto.class);
		Produto saveProdResponse = produtoRepository.save(produto);
		return modelMapper.map(saveProdResponse, ProdutoDTO.class);		
	}
	
	   public Boolean delProduto(Integer id) {
		  if(produtoRepository.findById(id).orElse(null)!=null) {
			  produtoRepository.deleteById(id);
			  if(produtoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	    	  
	      }
}
