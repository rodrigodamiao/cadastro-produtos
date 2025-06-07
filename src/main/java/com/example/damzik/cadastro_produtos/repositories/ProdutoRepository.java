package com.example.damzik.cadastro_produtos.repositories;

import com.example.damzik.cadastro_produtos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
