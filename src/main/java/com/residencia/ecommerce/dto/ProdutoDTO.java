package com.residencia.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.residencia.ecommerce.entities.Produto;



public class ProdutoDTO {
	
	private Integer idProduto;
	
	private String nome;
	
	private String descricao;
	
	private Integer qtdEstoque;
	
	private Date dataCadastro;

	private BigDecimal valorUnitario;

	private byte[] imagem; 

	private CategoriaDTO categoriaDTO;
	
	private List<ItemPedidoDTO> pedidos;

	public ProdutoDTO(Integer idProduto, String nome, String descricao, Integer qtdEstoque, Date dataCadastro,
			BigDecimal valorUnitario, byte[] imagem, CategoriaDTO categoriaDTO, List<ItemPedidoDTO> pedidos) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.descricao = descricao;
		this.qtdEstoque = qtdEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.imagem = imagem;
		this.categoriaDTO = categoriaDTO;
		this.pedidos = pedidos;
	}

	public ProdutoDTO() {
		super();		
	}
	public ProdutoDTO(Produto entity){
		BeanUtils.copyProperties(entity, this);	
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

	public CategoriaDTO getCategoriaDTO() {
		return categoriaDTO;
	}

	public void setCategoriaDTO(CategoriaDTO categoriaDTO) {
		this.categoriaDTO = categoriaDTO;
	}

	public List<ItemPedidoDTO> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<ItemPedidoDTO> pedidos) {
		this.pedidos = pedidos;
	}	
}
