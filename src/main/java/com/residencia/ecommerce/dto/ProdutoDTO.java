package com.residencia.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.ItemPedido;
import com.residencia.ecommerce.entities.Produto;


public class ProdutoDTO {
	
	@Autowired
	ModelMapper modelMapper;
	
	private Integer idProduto;
	
	private String nome;
	
	private String descricao;
	
	private Integer qtdEstoque;
	
	private Date dataCadastro;

	private BigDecimal valorUnitario;

	private byte[] imagem; 

	private CategoriaDTO categoria;
	
	private List<ItemPedido> itensPedidos;	

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
		this.categoria = modelMapper.map(produto.getCategoria(), CategoriaDTO.class);
		this.itensPedidos = produto.getItensPedidos();
	}

	public ProdutoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, Date dataCadastro,
			BigDecimal valorUnitario, byte[] imagem, Categoria categoria, List<ItemPedido> itensPedidos) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoria = modelMapper.map(categoria, CategoriaDTO.class);
		this.itensPedidos = itensPedidos;
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

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public List<ItemPedido> getItensPedidos() {
		return itensPedidos;
	}

	public void setItensPedidos(List<ItemPedido> itensPedidos) {
		this.itensPedidos = itensPedidos;
	}
}
