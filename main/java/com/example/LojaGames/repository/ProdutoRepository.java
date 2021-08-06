package com.example.LojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.LojaGames.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
 
	    public List<Produto> findAllByDescricaoContainingIgnoreCase (String descricao);
}
