package com.example.damzik.cadastro_produtos.services;

import com.example.damzik.cadastro_produtos.dto.request.UsuarioRequestDTO;
import com.example.damzik.cadastro_produtos.entities.Usuario;
import com.example.damzik.cadastro_produtos.exceptions.UsuarioNotFoundException;
import com.example.damzik.cadastro_produtos.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    // Métodos service:
    // Get usuarios, Get usuario por id, Cadastrar usuarios, Atualizar usuarios, Deletar usuarios
    // Depois criar metodos relacionados a pedidos e produtos (Get pedidos do usuario, atualizar pedido, deletar pedido, etc...)
    // Criar as tabelas de usuarios com pedidos e pedidos com produtos etc...

    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));
    }

    public Usuario cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario(usuarioRequestDTO);

        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuario.setNome(usuarioRequestDTO.getNome());
        usuario.setEmail(usuarioRequestDTO.getEmail());

        usuarioRepository.save(usuario);

        return usuario;
    }

    public Usuario deleteUsuarioById(Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(id));

        usuarioRepository.deleteById(id);

        return usuario;
    }
}
