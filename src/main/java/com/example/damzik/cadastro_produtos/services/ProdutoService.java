package com.example.damzik.cadastro_produtos.services;

import com.example.damzik.cadastro_produtos.dto.request.ProdutoRequestDTO;
import com.example.damzik.cadastro_produtos.entities.Produto;
import com.example.damzik.cadastro_produtos.exceptions.ProdutoNotFoundException;
import com.example.damzik.cadastro_produtos.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {

        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodosProdutos(){
        return produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id){
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));
    }

    public Produto salvarProduto(ProdutoRequestDTO produtoRequestDTO){
        Produto produto = new Produto(produtoRequestDTO);

        return produtoRepository.save(produto);
    }

    public Produto deleteProdutoById(Long id){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produtoRepository.deleteById(id);

        return produto;
    }

    public Produto updateProduto(Long id, ProdutoRequestDTO produtoRequestDTO){
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(() -> new ProdutoNotFoundException(id));

        produto.setNome(produtoRequestDTO.getNome());
        produto.setPreco(produtoRequestDTO.getPreco());

        return produtoRepository.save(produto);
    }
}
