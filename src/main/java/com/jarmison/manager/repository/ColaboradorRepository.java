package com.jarmison.manager.repository;

import com.jarmison.manager.entity.cadastros.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer> {

    @Query("SELECT c FROM Colaborador c JOIN FETCH c.pessoa p WHERE LOWER(p.nome) = LOWER(:nome)")
    List<Colaborador> findColaboradorByNome(@Param("nome") String nome);
}
