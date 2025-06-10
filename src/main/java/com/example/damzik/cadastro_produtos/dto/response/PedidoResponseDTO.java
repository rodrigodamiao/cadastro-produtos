package com.example.damzik.cadastro_produtos.dto.response;

import com.example.damzik.cadastro_produtos.entities.Pedido;
import com.example.damzik.cadastro_produtos.entities.Produto;

import java.time.LocalDateTime;
import java.util.List;

public class PedidoResponseDTO {
    private Long pedido_id;
    private Long usuario_id;

    private List<Produto> produtos;

    private Double precoTotal;

    private LocalDateTime data;

    public PedidoResponseDTO(Pedido pedido){
        this.pedido_id = pedido.getId();
        this.usuario_id = pedido.getUsuario().getId();
        this.produtos = pedido.getProdutos();
        this.precoTotal = pedido.getTotalPrice();
        this.data = pedido.getData();
    }

    public Long getPedido_id() {
        return pedido_id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public LocalDateTime getData() {
        return data;
    }
}
