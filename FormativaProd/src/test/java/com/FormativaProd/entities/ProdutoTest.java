package com.FormativaProd.entities;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.FormativaProd.entities.Produto;

class ProdutoTest {
	
	private Produto produto;
	
	@BeforeEach
	void setup() {
		//Arrange
		produto = new Produto(1l, "Pinho Sol", "o melhor desinfetante", 20.0);
	}

	@Test
	@DisplayName("Testando o getter e setter do campo ID")
	void testId() {
		//Act
		produto.setId(2l);
		//Assert
		assertEquals(2L, produto.getId());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Nome")
	void testNome() {
		//Act
		produto.setNome("pinho");
		//Assert
		assertEquals("pinho", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Descricao")
	void testDescricao() {
		//Act
		produto.setDescricao("muito bom");
		//Assert
		assertEquals("muito bom", produto.getDescricao());
	}
	
	@Test
	@DisplayName("Testando o getter e setter do campo Preco")
	void testPreco() {
		//Act
		produto.setPreco(30.0);
		//Assert
		assertEquals(30.0, produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o getter e setter de todos os campos")
	void testConstructorALL() {
		//Act
		Produto novoProduto = new Produto(3L, "Sol Pinho", "desinfetante", 40.0);
		//Assertion
		assertAll("novoHospede",
				()-> assertEquals(3L, novoProduto.getId()),
				()-> assertEquals("Sol Pinho", novoProduto.getNome()),
				()-> assertEquals("desinfetante", novoProduto.getDescricao()),
				()-> assertEquals(40.0, novoProduto.getPreco())


	);
	
	}
	
	
};
