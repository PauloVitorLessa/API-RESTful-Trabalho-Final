package com.residencia.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.dto.ProdutoDTO;
import com.residencia.ecommerce.services.ProdutoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService produtoService;
	
	@GetMapping
    public ResponseEntity<List<ProdutoDTO>> getAllProdutosDTO() {
        return new ResponseEntity<>(produtoService.getAllProdutosDTO(),
                HttpStatus.OK);
        //ResponseEntity manipula o retorno
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> getProdutoById(@PathVariable Integer id) {
        ProdutoDTO produtoDtoResponse = produtoService.getProdutoDtoById(id);
        if(null == produtoDtoResponse)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<>(produtoDtoResponse, HttpStatus.OK);
    }
    
    
    @PostMapping
    public ResponseEntity<ProdutoDTO> saveProdutoDTO(@Valid @RequestBody ProdutoDTO produtoDTO) {
        return new ResponseEntity<>(produtoService.saveProdutoDTO(produtoDTO),HttpStatus.CREATED);
    }
    
    @PutMapping
    public ResponseEntity<ProdutoDTO> updateProduto(@Valid @RequestBody ProdutoDTO produtoDTO) {
    	if(produtoService.getProdutoDtoById(produtoDTO.getIdProduto()) != null) {
            return new ResponseEntity<> (produtoService.updateProdutoDTO(produtoDTO),
                    HttpStatus.OK);
        }
        else {
            return new ResponseEntity<> (produtoDTO,
                    HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delProduto(@PathVariable Integer id) {
        Boolean resp = produtoService.delProduto(id);
        if(resp)
        	return new ResponseEntity<>(resp,HttpStatus.OK);
        else
        	return new ResponseEntity<>(resp,HttpStatus.NOT_MODIFIED);
    }

}



