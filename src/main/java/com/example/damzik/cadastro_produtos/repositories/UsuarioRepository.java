package com.example.damzik.cadastro_produtos.repositories;

import com.example.damzik.cadastro_produtos.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {
}
