package com.example.damzik.cadastro_produtos.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioRequestDTO {

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nome;

    @Email(message = "Email inválido.")
    @NotBlank(message = "O email não pode estar em branco.")
    private String email;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
