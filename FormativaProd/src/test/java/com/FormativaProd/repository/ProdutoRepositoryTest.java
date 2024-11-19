package com.FormativaProd.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.FormativaProd.entities.Produto;
import com.FormativaProd.repository.ProdutoRepository;

@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;

	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {

		// Given / Arrange
		Produto produto1 = new Produto(null, "queijo", "golda", 18.0);

		// When / Act
		Produto saveProduto = produtoRepository.save(produto1);

		// Then / Assert
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId() > 0);

	}

	@DisplayName("Testando Get para todos Produtos")
	@Test
	void testGetAllRepository() {

		// Given / Arrange
		Produto produto1 = new Produto(null, "queijo", "golda", 18.0);

		Produto produto2 = new Produto(null, "batata", "inglesa", 20.0);

		produtoRepository.save(produto1);
		produtoRepository.save(produto2);

		// When / Act
		List<Produto> produtoList = produtoRepository.findAll();

		// Then / Assert
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());

	}

	@DisplayName("Testando o Update")
	@Test
	void testUpdateProduto() {

		// Given / Arrange
		Produto produto1 = new Produto(null, "batata", "inglesa", 20.0);

		produtoRepository.save(produto1);

		// When / Act
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("batata");
		produto1.setDescricao("africana");
		produto1.setPreco(25.0);

		Produto updateProduto = produtoRepository.save(saveProduto);

		// Then / Assert
		assertNotNull(updateProduto);
		assertEquals("batata", updateProduto.getNome());
		assertEquals("africana", updateProduto.getDescricao());
		assertEquals(25.0, updateProduto.getPreco());

	}

	@DisplayName("testando o Delete")
	@Test
	void testDeleteProduto() {

		// Given / Arrange
		Produto produto1 = new Produto(null, "batata", "inglesa", 20.0);

		produtoRepository.save(produto1);

		// When / Act
		produtoRepository.deleteById(produto1.getId());

		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());

		// Then / Assert
		assertTrue(produtoOptional.isEmpty());

	}
}