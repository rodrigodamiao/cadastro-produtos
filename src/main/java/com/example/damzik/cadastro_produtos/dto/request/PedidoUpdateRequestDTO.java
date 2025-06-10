package com.example.damzik.cadastro_produtos.dto.request;

import com.example.damzik.cadastro_produtos.entities.Produto;

import java.util.List;

public class PedidoUpdateRequestDTO {

    private List<Long> produtosIds;

    public PedidoUpdateRequestDTO() {
    }

    public PedidoUpdateRequestDTO(List<Long> produtosIds) {
        this.produtosIds = produtosIds;
    }

    public List<Long> getProdutosIds() {
        return produtosIds;
    }
}
