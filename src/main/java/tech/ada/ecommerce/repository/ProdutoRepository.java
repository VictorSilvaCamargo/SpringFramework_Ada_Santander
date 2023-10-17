package tech.ada.ecommerce.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tech.ada.ecommerce.model.Produto;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.nome ILIKE concat('%', :nome, '%') ORDER BY p.nome")
    List<Produto> findByNomeCustom(@Param("nome") String nome);

    @Query("UPDATE Produto p SET p.qtdEstoque = :qtd WHERE p.id = :id")
    void atualizarEstoque(@Param("qtd") Long qtd, @Param("id") Long id);

    // Método para atualizar o nome do produto com base no id
    @Modifying
    @Query("UPDATE Produto p SET p.nome = :nome WHERE p.id = :id")
    void atualizarNome(@Param("id") Long id, @Param("nome") String nome);

    // Método para atualizar a descrição do produto com base no id
    @Modifying
    @Query("UPDATE Produto p SET p.descricao = :descricao WHERE p.id = :id")
    void atualizarDescricao(@Param("id") Long id, @Param("descricao") String descricao);

    // Método para atualizar o SKU do produto com base no id
    @Modifying
    @Query("UPDATE Produto p SET p.sku = :sku WHERE p.id = :id")
    void atualizarSKU(@Param("id") Long id, @Param("sku") String sku);

    // Método para atualizar o preço do produto com base no id
    @Modifying
    @Query("UPDATE Produto p SET p.preco = :preco WHERE p.id = :id")
    void atualizarPreco(@Param("id") Long id, @Param("preco") double preco);

/*
    List<Produto> findByPrecoBetween(Double preco1, Double preco2);

    Page<Produto> findByPrecoBetween(Double preco1, Double preco2, Pageable pageable);
    @Override
    Page<Produto> findAll(Pageable pageable);

    @Override
    List<Produto> findAll(Sort sort);

    List<Produto> findByPrecoBetween(Double preco1, Double preco2, Sort sort);
*/

}
