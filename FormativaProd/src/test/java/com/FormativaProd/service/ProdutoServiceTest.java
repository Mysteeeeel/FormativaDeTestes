package com.FormativaProd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.FormativaProd.entities.Produto;
import com.FormativaProd.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@SpringBootTest // Carrega o contexto completo do Spring para testes
@Transactional
class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ProdutoRepository produtoRepository;

	@BeforeEach
	void setUp() {
		produtoRepository.deleteAll(); // Limpa o banco de dados antes de cada teste

// Garante que as banco de dados operacoes no serao revertidas apos cada teste

	}


	@DisplayName("Testando salvar Produto")
	@Test
	void testSalvarProduto() {
		Produto produto = new Produto(null, "papel higienico", "folha dupla", 15.0 );

		Produto resultado = produtoService.salvarProduto(produto);

		assertNotNull(resultado);
		assertEquals("papel higienico", resultado.getNome());
		assertTrue(resultado.getId() > 0);

	}

	@DisplayName("Testando listar todos os Produtos")
	@Test
	void testListarTodos() {
		Produto produtol = new Produto(null, "papel higienico", "folha dupla", 15.0);
		Produto produto2 = new Produto(null, "palito de dente", "boa qualidade", 6.0);

		produtoService.salvarProduto(produtol);
		produtoService.salvarProduto(produto2);

		List<Produto> resultado = produtoService.listarTodos();

		assertNotNull(resultado);
		assertEquals(2, resultado.size());

	}

	@DisplayName("Testando buscar Hóspede por ID")
	@Test
	void testBuscarPorId() {
		Produto produto = new Produto(null, "papel higienico", "folha dupla", 15.0);

		Produto salvo = produtoService.salvarProduto(produto);
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());

		assertTrue(resultado.isPresent());
		assertEquals("papel higienico", resultado.get().getNome());

	}

	@DisplayName("Testando atualizar Hóspede")
	@Test
	void testAtualizarProduto() {
		Produto produto = new Produto(null, "papel higienico", "folha dupla", 15.0);
		Produto salvo = produtoService.salvarProduto(produto);

		salvo.setNome("refrigerante");
		salvo.setDescricao("o melhor sabor");

		Produto atualizado = produtoService.atualizarProduto(salvo);

		assertNotNull(atualizado);
		assertEquals("refrigerante", atualizado.getNome());
		assertEquals("o melhor sabor", atualizado.getDescricao());

	}

	@DisplayName ("Testando deletar Hóspede")
	@Test
	void testDeletarProduto () {
		Produto produto = new Produto (null, "papel higienico", "folha dupla", 15.0);

		Produto salvo = produtoService.salvarProduto (produto) ;
		produtoService.deletarProduto (salvo.getId());
	
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId() );

		assertTrue(resultado.isEmpty ());

	}
}
