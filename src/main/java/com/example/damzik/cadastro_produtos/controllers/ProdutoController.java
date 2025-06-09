package com.example.damzik.cadastro_produtos.controllers;

import com.example.damzik.cadastro_produtos.dto.request.ProdutoRequestDTO;
import com.example.damzik.cadastro_produtos.dto.response.ProdutoResponseDTO;
import com.example.damzik.cadastro_produtos.entities.Produto;
import com.example.damzik.cadastro_produtos.repositories.ProdutoRepository;
import com.example.damzik.cadastro_produtos.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoService produtoService, ProdutoRepository produtoRepository) {
        this.produtoService = produtoService;
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponseDTO>> findProdutos(){
        List<Produto> produtos = produtoService.listarTodosProdutos();
        List<ProdutoResponseDTO> produtosResponseDTO = produtos.stream()
                .map(produto -> new ProdutoResponseDTO(produto))
                .collect(Collectors.toList());

        return ResponseEntity.ok(produtosResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> findProdutoById(@PathVariable Long id){
        Produto produto = produtoService.buscarProdutoPorId(id);
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(produto);

        return ResponseEntity.ok(produtoResponseDTO);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponseDTO> addProduto(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO){
        Produto produto = produtoService.salvarProduto(produtoRequestDTO);
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(produto);

        return ResponseEntity.ok(produtoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponseDTO> updateProduto(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO dto){
        Produto updated = produtoService.updateProduto(id, dto);
        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO(updated);

        return ResponseEntity.ok(produtoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProdutoById(@PathVariable Long id){
        Produto produto = produtoService.deleteProdutoById(id);
        String message = String.format("O produto de id %s (Nome: %s / Preço: R$%s) foi deletado com sucesso.",
                id, produto.getNome(), produto.getPreco());

        return ResponseEntity.ok(message);
    }
}
