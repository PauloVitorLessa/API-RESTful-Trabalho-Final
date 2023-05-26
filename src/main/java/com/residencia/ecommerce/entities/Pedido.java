package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@JsonIdentityInfo(
		scope = Pedido.class,
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "idPedido"
		)
@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id // indica que esse atributo é chave primaria (obrigatorio)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica se o java ou o banco de dados será responsavel pelo autoincremento
	@Column(name = "id_pedido")
	private Integer idPedido;
	
	@NotNull
	@Column(name = "data_pedido")
	private Instant dataPedido;
	
	@NotNull
	@Column(name = "data_entrega")
	private Instant dataEntrega;
	
	@NotNull
	@Column(name = "data_envio")
	private Instant dataEnvio;

	@NotNull
	@Column(name = "status")
	private String status;
	
	@Column(name = "valor_total")
	private BigDecimal valorTotal;
	
	@NotNull
	@ManyToOne //JoinColumn é para quem recebe a chave estrangeira
	@JoinColumn(name = "id_cliente", 
					referencedColumnName = "id_cliente")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "pedido")
	private List<ItemPedido> produtos;
	
	public Integer getIdPedido() {
		return idPedido;
	}



	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}



	public Instant getDataPedido() {
		return dataPedido;
	}



	public void setDataPedido(Instant dataPedido) {
		this.dataPedido = dataPedido;
	}



	public Instant getDataEntrega() {
		return dataEntrega;
	}



	public void setDataEntrega(Instant dataEntrega) {
		this.dataEntrega = dataEntrega;
	}



	public Instant getDataEnvio() {
		return dataEnvio;
	}



	public void setDataEnvio(Instant dataEnvio) {
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



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public List<ItemPedido> getProdutos() {
		return produtos;
	}



	public void setProdutos(List<ItemPedido> produtos) {
		this.produtos = produtos;
	}



	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", dataPedido=" + dataPedido + ", dataEntrega="
				+ dataEntrega + ", dataEnvio=" + dataEnvio + ", status=" + status + ", valorTotal=" + valorTotal
				+ ", cliente=" + cliente + "]";
	}
}
