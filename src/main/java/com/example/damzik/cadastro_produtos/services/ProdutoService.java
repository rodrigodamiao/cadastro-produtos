package com.example.damzik.cadastro_produtos.services;

import com.example.damzik.cadastro_produtos.dto.ProdutoDTO;
import com.example.damzik.cadastro_produtos.entities.Produto;
import com.example.damzik.cadastro_produtos.exceptions.ProdutoNotFoundException;
import com.example.damzik.cadastro_produtos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> listarTodosProdutos(){
        return repository.findAll();
    }

    public Produto buscarProdutoPorId(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    public Produto salvarProduto(Produto produto){
        return repository.save(produto);
    }

    public Produto deleteProdutoById(Long id){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        repository.deleteById(id);

        return produto;
    }

    public Produto updateProduto(Long id, ProdutoDTO dto){
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        return repository.save(produto);
    }
}
