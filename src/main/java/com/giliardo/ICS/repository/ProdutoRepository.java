package com.giliardo.ICS.repository;

import com.giliardo.ICS.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // O JpaRepository já implementa os seguintes métodos:
    // List<Usuario> findAll(); -> Retorna todos os usuários do banco de dados
    // Optional<Usuario> findById(Long id); -> Retorna um usuário pelo ID
    // Usuario save(Usuario usuario); -> Salva ou atualiza um usuário
    // void delete(Usuario usuario); -> Exclui um usuário

}
