package com.example.damzik.cadastro_produtos.controllers;

import com.example.damzik.cadastro_produtos.dto.request.UsuarioRequestDTO;
import com.example.damzik.cadastro_produtos.dto.response.UsuarioResponseDTO;
import com.example.damzik.cadastro_produtos.entities.Usuario;
import com.example.damzik.cadastro_produtos.repositories.UsuarioRepository;
import com.example.damzik.cadastro_produtos.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    // Depois criar metodos relacionados a pedidos e produtos (Get pedidos do usuario, atualizar pedido, deletar pedido, etc...)

    private final UsuarioService usuarioService;

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioService usuarioService, UsuarioRepository usuarioRepository) {
        this.usuarioService = usuarioService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios(){
        List<Usuario> usuarios = usuarioService.listarUsuarios();

        List<UsuarioResponseDTO> usuariosResponseDTO = usuarios
                .stream()
                .map(usuario -> new UsuarioResponseDTO(usuario))
                .collect(Collectors.toList());

        return ResponseEntity.ok(usuariosResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> getUsuarioById(@PathVariable Long id){
        Usuario usuario = usuarioService.getUsuarioById(id);
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(usuario);

        return ResponseEntity.ok(usuarioResponseDTO);
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> cadastrarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = usuarioService.cadastrarUsuario(usuarioRequestDTO);
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(usuario);

        return ResponseEntity.ok(usuarioResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> updateUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO){
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioRequestDTO);
        UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO(updatedUsuario);

        return ResponseEntity.ok(usuarioResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        Usuario usuario = usuarioService.deleteUsuarioById(id);
        String message = String.format("O usuário de id %s (Nome: %s / Email: %s) foi deletado com sucesso.", id, usuario.getNome(), usuario.getEmail());

        return ResponseEntity.ok(message);
    }
}
