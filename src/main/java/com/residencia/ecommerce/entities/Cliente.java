package com.residencia.ecommerce.entities;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@JsonIdentityInfo(
		scope = Cliente.class,
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "id_cliente"
		)
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id // indica que esse atributo é chave primaria (obrigatorio)
	@GeneratedValue(strategy = GenerationType.IDENTITY) // indica se o java ou o banco de dados será responsavel pelo autoincremento
	@Column(name = "id_cliente")
	private Integer numeroIdCliente;
	
	@Column(name = "cpf")
	private Integer cpf;
	
	@Column(name = "nome_completo")
	private String nome;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telefone")
	private String telefone;
	
	@Column(name = "data_nascimento")
	private Instant dataNascimento;
	
	//cardinalidade 1:1
	@OneToOne
	@JoinColumn(name = "id_endereco", 
			referencedColumnName = "id_endereco")
	private Endereco endereco; // relacionando a classe endereço com o cliente
	
	//cardinalidade 1:N
	@OneToMany(mappedBy = "cliente") //linkando com o "cliente" criado no pedido
	private List<Pedido> pedido; // 1 cliente pode ter N pedidos

	public Integer getNumeroIdCliente() {
		return numeroIdCliente;
	}

	public void setNumeroIdCliente(Integer numeroIdCliente) {
		this.numeroIdCliente = numeroIdCliente;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getPedido() {
		return pedido;
	}

	public void setPedido(List<Pedido> pedido) {
		this.pedido = pedido;
	}

	@Override
	public String toString() {
		return "Cliente [numeroIdCliente=" + numeroIdCliente + ", cpf=" + cpf + ", nome=" + nome + ", email=" + email
				+ ", telefone=" + telefone + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco
				+ ", pedido=" + pedido + "]";
	}
	
}
