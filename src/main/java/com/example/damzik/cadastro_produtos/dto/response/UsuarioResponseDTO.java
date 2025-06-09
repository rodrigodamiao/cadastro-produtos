package com.example.damzik.cadastro_produtos.dto.response;

import com.example.damzik.cadastro_produtos.entities.Usuario;

public class UsuarioResponseDTO {

    private final Long id;
    private final String nome;
    private final String email;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
