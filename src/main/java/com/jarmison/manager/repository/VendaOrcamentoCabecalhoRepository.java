package com.jarmison.manager.repository;

import com.jarmison.manager.entity.vendas.VendaOrcamentoCabecalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VendaOrcamentoCabecalhoRepository extends JpaRepository<VendaOrcamentoCabecalho, Integer> {
    @Query("SELECT v FROM VendaOrcamentoCabecalho v WHERE v.codigo = :codigo")
    List<VendaOrcamentoCabecalho> buscarVendasOrcamentoCabelhado(String codigo);

    @Query("SELECT DISTINCT v FROM VendaOrcamentoCabecalho v LEFT JOIN FETCH v.listaVendaOrcamentoDetalhe WHERE v.id = :id")
    VendaOrcamentoCabecalho buscarVendaOrcamentoCabecalho(@Param("id") Integer id);

}
