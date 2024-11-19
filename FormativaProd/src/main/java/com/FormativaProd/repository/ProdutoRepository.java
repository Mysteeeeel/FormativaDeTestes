package com.FormativaProd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FormativaProd.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
