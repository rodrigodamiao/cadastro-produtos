package com.example.damzik.cadastro_produtos.controllers;

import com.example.damzik.cadastro_produtos.dto.request.PedidoRequestDTO;
import com.example.damzik.cadastro_produtos.dto.request.PedidoUpdateRequestDTO;
import com.example.damzik.cadastro_produtos.dto.request.ProdutoRequestDTO;
import com.example.damzik.cadastro_produtos.dto.response.PedidoResponseDTO;
import com.example.damzik.cadastro_produtos.dto.response.ProdutoResponseDTO;
import com.example.damzik.cadastro_produtos.entities.Pedido;
import com.example.damzik.cadastro_produtos.entities.Produto;
import com.example.damzik.cadastro_produtos.repositories.PedidoRepository;
import com.example.damzik.cadastro_produtos.services.PedidoService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    private final PedidoRepository pedidoRepository;

    public PedidoController(PedidoService pedidoService, PedidoRepository pedidoRepository) {
        this.pedidoService = pedidoService;
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping
    public ResponseEntity<List<PedidoResponseDTO>> getPedidos(){
        List<Pedido> pedidos = pedidoService.getPedidos();
        List<PedidoResponseDTO> pedidosResponseDTO = pedidos.stream()
                .map(PedidoResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> getPedidoById(@PathVariable Long id){
        Pedido pedido = pedidoService.getPedidoById(id);
        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO(pedido);

        return ResponseEntity.ok(pedidoResponseDTO);
    }

    @GetMapping("/usuario/{userId}")
    public ResponseEntity<List<PedidoResponseDTO>> getPedidoByUserId(@PathVariable Long userId){
        List<Pedido> pedidos = pedidoService.getPedidoByUserId(userId);
        List<PedidoResponseDTO> pedidosResponseDTO = pedidos.stream()
                .map(PedidoResponseDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(pedidosResponseDTO);
    }

    @PostMapping
    public ResponseEntity<PedidoResponseDTO> criarPedido(@RequestBody PedidoRequestDTO pedidoRequestDTO) {
        Pedido pedido = pedidoService.criarPedido(pedidoRequestDTO);

        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO(pedido);

        return ResponseEntity.ok(pedidoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoResponseDTO> atualizarPedido(@PathVariable Long id, @RequestBody PedidoUpdateRequestDTO pedidoUpdateRequestDTO){
        Pedido pedido = pedidoService.atualizarPedido(id, pedidoUpdateRequestDTO);

        PedidoResponseDTO pedidoResponseDTO = new PedidoResponseDTO(pedido);

        return ResponseEntity.ok(pedidoResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);

        String message = String.format("O pedido de id %s foi deletado com sucesso.", id);

        return ResponseEntity.ok(message);
    }
}
