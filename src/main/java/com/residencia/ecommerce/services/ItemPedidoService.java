package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ItemPedido;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ItemPedidoRepository;
import com.residencia.ecommerce.repositories.ProdutoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
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
		if (produto.getQtdEstoque() >= quantidade) {
			produto.setQtdEstoque(produto.getQtdEstoque() - quantidade);
			produtoRepository.save(produto);
			return itemPedidoRepository.save(itemPedido);
		}
		else {
			return itemPedido;
		}
		 
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
