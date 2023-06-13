package com.residencia.ecommerce.dto;

import com.residencia.ecommerce.entities.Categoria;


public class CategoriaDTO {
	

private Integer idCategoria;
	
	
private String nome;
	

private String descricao;


public CategoriaDTO() {
	super();

}
public CategoriaDTO(Categoria categoria) {
	super();
	this.idCategoria = categoria.getIdCategoria();
	this.nome = categoria.getNome();
	this.descricao = categoria.getDescricao();	
}




public CategoriaDTO(Integer idCategoria, String nome, String descricao) {
	super();
	this.idCategoria = idCategoria;
	this.nome = nome;
	this.descricao = descricao;
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
	
}
