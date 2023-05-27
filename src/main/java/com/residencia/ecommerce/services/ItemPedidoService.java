package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ItemPedido;
import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.exceptions.CustomException;
import com.residencia.ecommerce.repositories.ItemPedidoRepository;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.repositories.ProdutoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<ItemPedido> getAllItemPedidos() {
		List<ItemPedido> itemPedidos = itemPedidoRepository.findAll();
				
		return itemPedidos;
	}
	
	public ItemPedido getItemPedidoById(Integer id) {
		ItemPedido itemPedido = itemPedidoRepository.findById(id).orElse(null);
		
		if(itemPedido==null)
			return null;
		
		return itemPedido;
		
	}
	
	public ItemPedido saveItemPedido(ItemPedido itemPedido) {
		Integer quantidade = itemPedido.getQuantidade();
		Produto produto = produtoRepository.findById(itemPedido.getProduto().getIdProduto()).orElse(null);
		Pedido pedido = pedidoRepository.findById(itemPedido.getPedido().getIdPedido()).orElse(null);
		if(produto == null) {
			throw new CustomException("Produto de id: "+itemPedido.getProduto().getIdProduto()+ " não encontrado");
		}
		if(pedido == null) {
			throw new CustomException("Pedido de id: "+itemPedido.getPedido().getIdPedido()+ " não encontrado");
		}
		if (produto.getQtdEstoque() >= quantidade) {
			
			ItemPedido saveItemPedidoResponse = itemPedidoRepository.save(itemPedido);
			if(saveItemPedidoResponse != null) {
				produto.setQtdEstoque(produto.getQtdEstoque() - quantidade);
				produtoRepository.save(produto);
				pedido.setValorTotal(pedido.getValorTotal().add(saveItemPedidoResponse.getValorLiquido()));
				if(itemPedido.getStatus()=="fechado") {
					pedido.setStatus(itemPedido.getStatus());
					Pedido savePedidoResponse = pedidoRepository.save(pedido);
					if(savePedidoResponse == null) {
						throw new CustomException("Erro ao atualizar o pedido no banco de dados");
					}
					return saveItemPedidoResponse;
					
				}
			}else {
				throw new CustomException("Erro ao salvar o itemPedido no banco de dados");
			}
		}
		else {
			throw new CustomException("Estoque insuficiente do produto");
		}
		return itemPedido;
		 
	}
	
	public ItemPedido updateItemPedido(ItemPedido itemPedido) {
	
		return itemPedidoRepository.save(itemPedido);
		
		
	}
	
	   public Boolean delItemPedido(Integer id) {
		  if(itemPedidoRepository.findById(id).orElse(null)!=null) {
			  itemPedidoRepository.deleteById(id);
			  if(itemPedidoRepository.findById(id).orElse(null)==null)
				  return true;
		     else
		    	 return false;
		  }
		    else return false;
	    	  
	      }
	

}
