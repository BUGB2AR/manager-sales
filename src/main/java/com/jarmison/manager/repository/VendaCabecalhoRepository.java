package com.jarmison.manager.repository;

import com.jarmison.manager.entity.vendas.VendaCabecalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface VendaCabecalhoRepository extends JpaRepository<VendaCabecalho, Integer> {
    @Query("SELECT v FROM VendaCabecalho v WHERE v.numeroFatura = :numeroFatura")
    Optional<VendaCabecalho> findByNumeroFatura(@Param("numeroFatura") Integer numeroFatura);

    @Query("SELECT vc FROM VendaCabecalho vc JOIN FETCH vc.vendaOrcamentoCabecalho voc WHERE voc.id = :orcamentoId")
    VendaCabecalho findByVendaOrcamentoId(@Param("orcamentoId") Integer orcamentoId);
}
