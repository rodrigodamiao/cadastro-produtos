package com.example.damzik.cadastro_produtos.dto.response;

import com.example.damzik.cadastro_produtos.entities.Produto;

public class ProdutoResponseDTO {

    private final Long id;
    private final String nome;
    private final Double preco;

    public ProdutoResponseDTO(Produto produto) {
        this.id = produto.getId();
        this.nome = produto.getNome();
        this.preco = produto.getPreco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }
}
