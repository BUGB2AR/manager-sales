package com.jarmison.manager.repository;

import com.jarmison.manager.entity.vendas.CondicoesPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface CondicoesPagamentoRepository extends JpaRepository<CondicoesPagamento, Integer> {
    @Query("SELECT c FROM CondicoesPagamento c WHERE c.nome LIKE %:nome%")
    List<CondicoesPagamento> buscarCondicoesPagamento(@Param("nome") String nome);
}
