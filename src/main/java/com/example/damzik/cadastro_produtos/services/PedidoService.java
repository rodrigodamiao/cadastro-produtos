package com.example.damzik.cadastro_produtos.services;

import com.example.damzik.cadastro_produtos.dto.request.PedidoRequestDTO;
import com.example.damzik.cadastro_produtos.dto.request.PedidoUpdateRequestDTO;
import com.example.damzik.cadastro_produtos.entities.Pedido;
import com.example.damzik.cadastro_produtos.entities.Produto;
import com.example.damzik.cadastro_produtos.entities.Usuario;
import com.example.damzik.cadastro_produtos.exceptions.PedidoNotFoundException;
import com.example.damzik.cadastro_produtos.exceptions.UsuarioNotFoundException;
import com.example.damzik.cadastro_produtos.repositories.PedidoRepository;
import com.example.damzik.cadastro_produtos.repositories.ProdutoRepository;
import com.example.damzik.cadastro_produtos.repositories.UsuarioRepository;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    // get pedido por id, get todos pedidos
    // get pedido by user id (retornar todos os pedidos daquele usuario)
    // criar pedido, atualizar pedido, deletar pedido

    private final PedidoRepository pedidoRepository;
    private final ProdutoRepository produtoRepository;
    private final UsuarioRepository usuarioRepository;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoRepository produtoRepository, UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.produtoRepository = produtoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Pedido> getPedidos(){
        return pedidoRepository.findAll();
    }

    public Pedido getPedidoById(Long id){
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
    }

    public List<Pedido> getPedidoByUserId(Long id){
        return pedidoRepository.findByUsuarioId(id);
    }

    public Pedido criarPedido(PedidoRequestDTO pedidoRequestDTO) {
        Usuario usuario = usuarioRepository.findById(pedidoRequestDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNotFoundException(pedidoRequestDTO.getUsuarioId()));

        List<Produto> produtos = produtoRepository.findAllById(pedidoRequestDTO.getProdutosIds());

        Pedido pedido = new Pedido();
        pedido.setUsuario(usuario);
        pedido.setProdutos(produtos);
        pedido.setData(LocalDateTime.now());

        double total = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        pedido.setTotalPrice(total);

        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarPedido(Long id, PedidoUpdateRequestDTO pedidoUpdateRequestDTO){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));

        List<Produto> produtos = produtoRepository.findAllById(pedidoUpdateRequestDTO.getProdutosIds());

        double totalPrice = produtos.stream().mapToDouble(Produto::getPreco).sum();

        pedido.setProdutos(produtos);
        pedido.setTotalPrice(totalPrice);

        return pedidoRepository.save(pedido);
    }

    public Pedido deletarPedido(Long id){
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new PedidoNotFoundException(id));
        pedidoRepository.deleteById(id);

        return pedido;
    }
}
