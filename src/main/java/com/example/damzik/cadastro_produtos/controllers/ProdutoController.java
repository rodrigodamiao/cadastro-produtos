package com.example.damzik.cadastro_produtos.controllers;

import com.example.damzik.cadastro_produtos.dto.ProdutoDTO;
import com.example.damzik.cadastro_produtos.entities.Produto;
import com.example.damzik.cadastro_produtos.exceptions.ProdutoNotFoundException;
import com.example.damzik.cadastro_produtos.repositories.ProdutoRepository;
import com.example.damzik.cadastro_produtos.services.ProdutoService;
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

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    private final ProdutoRepository repository;

    public ProdutoController(ProdutoService service, ProdutoRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> findProdutos(){
        List<Produto> produtos = service.listarTodosProdutos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findProdutoById(@PathVariable Long id){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<Produto> addProduto(@RequestBody Produto produto){
        repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> updateProduto(@PathVariable Long id, @RequestBody ProdutoDTO dto){
        Produto updated = service.updateProduto(id, dto);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProdutoById(@PathVariable Long id){

        Produto produto = service.deleteProdutoById(id);

        String message = String.format("O produto %s R$%s de id %s foi deletado com sucesso.",
                produto.getNome(), produto.getPreco(), id);

        return ResponseEntity.ok(message);
    }
}
