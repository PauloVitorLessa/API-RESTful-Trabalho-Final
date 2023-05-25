package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id // indica que esse atributo é chave primaria (obrigatorio)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica se o java ou o banco de dados será responsavel pelo autoincremento
	@Column(name = "id_produto")
	private Integer idProduto;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "qtd_estoque")
	private Integer qtdEstoque;
	
	@Column(name = "data_cadastro")
	private Instant dataCadastro;
	
	@Column(name = "valor_unitario")
	private BigDecimal valorUnitario;
	
	@Column(name = "imagem")
	private byte[] imagem; 
	
	@ManyToOne 
	@JoinColumn(name = "id_categoria", 
					referencedColumnName = "id_categoria")
	private Categoria categoria;
	
	@OneToMany(mappedBy = "produto")
	private Set<Pedido> pedidos = new HashSet<>();
}
