package com.example.damzik.cadastro_produtos.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PedidoRequestDTO {

    @NotNull
    private Long usuarioId;

    @NotEmpty
    private List<Long> produtosIds = new ArrayList<>();

    public PedidoRequestDTO() {
    }

    public PedidoRequestDTO(Long usuarioId, List<Long> produtosIds) {
        this.usuarioId = usuarioId;
        this.produtosIds = produtosIds;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public List<Long> getProdutosIds() {
        return produtosIds;
    }
}
