package com.example.damzik.cadastro_produtos.exceptions;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Long id) {
        super(String.format("Usuário com o id %d não encontrado.", id));
    }
}
