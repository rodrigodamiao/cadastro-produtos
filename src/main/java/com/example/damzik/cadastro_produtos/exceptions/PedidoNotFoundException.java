package com.example.damzik.cadastro_produtos.exceptions;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException(Long id) {
        super(String.format("O pedido de id %s não foi encontrado.", id));

    }
}
