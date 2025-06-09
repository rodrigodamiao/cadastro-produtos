package com.example.damzik.cadastro_produtos.exceptions;

public class ProdutoNotFoundException extends RuntimeException{
    public ProdutoNotFoundException(Long id) {
        super(String.format("Produto com o id %d não encontrado.", id));
    }
}
