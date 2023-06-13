package com.residencia.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.residencia.ecommerce.entities.Produto;


public class ProdutoDTO {
	
	
	private Integer idProduto;
	
	private String nome;
	
	private String descricao;
	
	private Integer qtdEstoque;
	
	private Date dataCadastro;

	private BigDecimal valorUnitario;

	private byte[] imagem; 

	private Integer idCategoria;
	
	private String nomeCategoria;	

	public ProdutoDTO() {
		super();		
	}
	public ProdutoDTO(Produto produto) {
		this.idProduto = produto.getIdProduto();
		this.nome = produto.getNome();
		this.descricao = produto.getDescricao();
		this.qtdEstoque = produto.getQtdEstoque();
		this.dataCadastro = produto.getDataCadastro();
		this.valorUnitario = produto.getValorUnitario();
		this.imagem = produto.getImagem();		
		this.idCategoria = produto.getCategoria().getIdCategoria();
		this.nomeCategoria = produto.getCategoria().getNome();
	}

	
	
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public ProdutoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, Date dataCadastro,
			BigDecimal valorUnitario, byte[] imagem, Integer idCategoria, String nomeCategoria) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.idCategoria = idCategoria;
		this.nomeCategoria = nomeCategoria;
	}
	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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

	public Integer getQtdEstoque() {
		return qtdEstoque;
	}

	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	
}
