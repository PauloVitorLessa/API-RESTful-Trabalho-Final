package com.residencia.ecommerce.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Produto;


public class CategoriaDTO {
	
	@Autowired
	ModelMapper modelMapper;

private Integer idCategoria;
	
	
private String nome;
	

private String descricao;
	

private List<ProdutoDTO> produtos;


public CategoriaDTO() {
	super();

}
public CategoriaDTO(Categoria categoria) {
	super();
	this.idCategoria = categoria.getIdCategoria();
	this.nome = categoria.getNome();
	this.descricao = categoria.getDescricao();
	List <ProdutoDTO> listaProdutoDTO = new ArrayList <>();
	for(Produto produto : categoria.getProdutos()) {
		ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
		listaProdutoDTO.add(produtoDTO);
	}
	this.produtos = listaProdutoDTO;
	
}

public CategoriaDTO(Integer idCategoria, String nome, String descricao, List<Produto> produtos) {
	super();
	this.idCategoria = idCategoria;
	this.nome = nome;
	this.descricao = descricao;
	List <ProdutoDTO> listaProdutoDTO = new ArrayList <>();
	for(Produto produto : produtos) {
		ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);
		listaProdutoDTO.add(produtoDTO);
	}
	
	this.produtos = listaProdutoDTO;
}


public Integer getIdCategoria() {
	return idCategoria;
}


public void setIdCategoria(Integer idCategoria) {
	this.idCategoria = idCategoria;
}


public String getNome() {
	return nome;
}


public void setNome(String nome) {
	this.nome = nome;
}


public String getDescricao() {
	return descricao;
}


public void setDescricao(String descricao) {
	this.descricao = descricao;
}


public List<ProdutoDTO> getProdutos() {
	return produtos;
}


public void setProdutos(List<ProdutoDTO> produtos) {
	this.produtos = produtos;
} 
	
}
