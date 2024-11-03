package com.jarmison.manager.repository;

import com.jarmison.manager.entity.vendas.NotaFiscalTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface NotaFiscalTipoRepository extends JpaRepository<NotaFiscalTipo, Integer> {
    @Query("SELECT v FROM NotaFiscalTipo v WHERE v.nome LIKE %:nome%")
    List<NotaFiscalTipo> buscarNotaFiscalTipo(@Param("nome") String nome);

}
