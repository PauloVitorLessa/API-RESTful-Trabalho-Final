package com.residencia.ecommerce.dto;

import java.math.BigDecimal;

import org.springframework.beans.BeanUtils;

import com.residencia.ecommerce.entities.ItemPedido;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

public class ItemPedidoDTO {
	
	private Integer idItemPedido;
	
	private Integer quantidade;
	
	private BigDecimal precoVenda;
	
	private BigDecimal percentualDesconto;
	
	private BigDecimal valorBruto;
	
	private BigDecimal valorLiquido;
	
	private PedidoDTO pedidoDTO;
	
	private ProdutoDTO produtoDTO;
	
	String status;

	public ItemPedidoDTO(@Min(1) Integer quantidade, @DecimalMin("0.0") @DecimalMax("1.0") BigDecimal percentualDesconto,
			PedidoDTO pedidoDTO, ProdutoDTO produtoDTO, String status) {
		super();
		this.quantidade = quantidade;
		this.percentualDesconto = percentualDesconto;
		this.pedidoDTO = pedidoDTO;
		this.produtoDTO = produtoDTO;
		this.status = status;		
		this.precoVenda = produtoDTO.getValorUnitario();
		this.valorBruto = this.precoVenda.multiply(BigDecimal.valueOf(quantidade));
		this.valorLiquido = this.valorBruto.subtract(this.valorBruto.multiply(percentualDesconto));
	}

	public ItemPedidoDTO() {
		super();		
	}
	public ItemPedidoDTO(ItemPedido entity) {
		BeanUtils.copyProperties(entity, this);
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

	public PedidoDTO getPedidoDTO() {
		return pedidoDTO;
	}

	public void setPedidoDTO(PedidoDTO pedidoDTO) {
		this.pedidoDTO = pedidoDTO;
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
