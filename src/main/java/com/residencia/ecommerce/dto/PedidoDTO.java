package com.residencia.ecommerce.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.residencia.ecommerce.entities.Pedido;


public class PedidoDTO {
	
		
	private Integer idPedido;
	
	private Date dataPedido;
	
	private Date dataEntrega;
	
	private Date dataEnvio;
	
	private String status;
	
	private BigDecimal valorTotal;
	
	private Integer idCliente;
	
	private List<ItemPedidoDTO> itensPedidosDTO;
	
	public PedidoDTO(Pedido pedido) {
		
		this.idPedido = pedido.getIdPedido();
		this.dataPedido =pedido.getDataPedido();
		this.dataEntrega = pedido.getDataEntrega();
		this.dataEnvio = pedido.getDataEnvio();
		this.status = pedido.getStatus();
		this.valorTotal = pedido.getValorTotal();
		this.idCliente = pedido.getCliente().getIdCliente();
		
		
	}	

	public PedidoDTO() {
		super();
	}

	public PedidoDTO(Integer idPedido, Date dataPedido, Date dataEntrega, Date dataEnvio, String status,
			BigDecimal valorTotal, Integer idCliente) {
		super();
		this.idPedido = idPedido;
		this.dataPedido = dataPedido;
		this.dataEntrega = dataEntrega;
		this.dataEnvio = dataEnvio;
		this.status = status;
		this.valorTotal = valorTotal;
		this.idCliente = idCliente;
		
	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public List<ItemPedidoDTO> getItensPedidosDTO() {
		return itensPedidosDTO;
	}

	public void setItensPedidosDTO(List<ItemPedidoDTO> itensPedidosDTO) {
		this.itensPedidosDTO = itensPedidosDTO;
	}		
}
