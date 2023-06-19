package com.residencia.ecommerce.dto;

import java.math.BigDecimal;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.residencia.ecommerce.entities.ItemPedido;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ItemPedidoDTO {
	
	@Autowired
	ModelMapper modelMapper;
	
	private Integer idItemPedido;
	@NotNull
	@Min (1)
	private Integer quantidade;
	
	private BigDecimal precoVenda;
	@DecimalMin(value = "0.0")
	@DecimalMax(value = "1.0")
	private BigDecimal percentualDesconto;
	
	private BigDecimal valorBruto;
	
	private BigDecimal valorLiquido;
	@NotNull
	private Integer idPedidoDTO;
	@NotNull
	private ProdutoDTO produtoDTO;
	@NotNull
	@NotBlank
	String status;
	
	public ItemPedidoDTO(ItemPedido itemPedido) {
		super();
		this.idItemPedido = itemPedido.getIdItemPedido();
		this.quantidade = itemPedido.getQuantidade();
		this.precoVenda = itemPedido.getPrecoVenda();
		this.percentualDesconto = itemPedido.getPercentualDesconto();
		this.valorBruto = itemPedido.getValorBruto();
		this.valorLiquido = itemPedido.getValorLiquido();
		this.idPedidoDTO = itemPedido.getPedido().getIdPedido();		
		this.produtoDTO = modelMapper.map(itemPedido.getProduto(), ProdutoDTO.class)   ;
		this.status = itemPedido.getStatus();
	}

	public ItemPedidoDTO() {
		super();
	}

	public ItemPedidoDTO(Integer idItemPedido, @NotNull @Min(1) Integer quantidade, BigDecimal precoVenda,
			@DecimalMin("0.0") @DecimalMax("1.0") BigDecimal percentualDesconto, BigDecimal valorBruto,
			BigDecimal valorLiquido, @NotNull Integer idPedido, @NotNull ProdutoDTO produtoDTO,
			@NotNull @NotBlank String status) {
		super();
		this.idItemPedido = idItemPedido;
		this.quantidade = quantidade;
		this.precoVenda = precoVenda;
		this.percentualDesconto = percentualDesconto;
		this.valorBruto = valorBruto;
		this.valorLiquido = valorLiquido;
		this.idPedidoDTO = idPedido;
		this.produtoDTO = produtoDTO;
		this.status = status;
	}

	public Integer getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Integer idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(BigDecimal precoVenda) {
		this.precoVenda = precoVenda;
	}

	public BigDecimal getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(BigDecimal percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}

	public BigDecimal getValorBruto() {
		return valorBruto;
	}

	public void setValorBruto(BigDecimal valorBruto) {
		this.valorBruto = valorBruto;
	}

	public BigDecimal getValorLiquido() {
		return valorLiquido;
	}

	public void setValorLiquido(BigDecimal valorLiquido) {
		this.valorLiquido = valorLiquido;
	}

	public Integer getIdPedidoDTO() {
		return idPedidoDTO;
	}

	public void setIdPedidoDTO(Integer idPedido) {
		this.idPedidoDTO = idPedido;
	}

	public ProdutoDTO getProdutoDTO() {
		return produtoDTO;
	}

	public void setProdutoDTO(ProdutoDTO produtoDTO) {
		this.produtoDTO = produtoDTO;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}	
}
