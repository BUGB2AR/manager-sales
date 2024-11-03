package com.jarmison.manager.repository;

import com.jarmison.manager.entity.cadastros.Transportadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface TransportadoraRepository extends JpaRepository<Transportadora, Integer> {
    @Query("SELECT t FROM Transportadora t JOIN FETCH t.pessoa p WHERE p.nome LIKE CONCAT('%', :nome, '%')")
    List<Transportadora> buscarTransportadora(@Param("nome") String nome);
}
