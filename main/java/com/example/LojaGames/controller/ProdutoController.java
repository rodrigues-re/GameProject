package com.example.LojaGames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.LojaGames.model.Produto;
import com.example.LojaGames.repository.ProdutoRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired 
	private ProdutoRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		return ResponseEntity.ok(repository.findAll());
	}

@GetMapping("/{idproduto}")
       public ResponseEntity<Produto> getById(@PathVariable long idproduto){
	         return repository.findById(idproduto).map(resp ->ResponseEntity.ok(resp))
	        		 .orElse(ResponseEntity.notFound().build());
}
	
   @GetMapping ("/nome/{nome_produto}")
       public ResponseEntity<List<Produto>> getByName(@PathVariable String nome_produto){
	          return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome_produto));
   }
	
	@PostMapping
	public ResponseEntity<Produto> savecategoria (@Valid @RequestBody Produto produto){
		return ResponseEntity.status(200).body(repository.save(produto));
	}
	
	@PutMapping
    public ResponseEntity<Produto> updateProduto (@Valid @RequestBody Produto produto){
		      return ResponseEntity.status(200).body(repository.save(produto));
	}
        
	@DeleteMapping("/{idproduto}")
    public void delete (@PathVariable long idproduto) {
		repository.deleteById(idproduto);
	}

       

	
	
	
	
	
}
