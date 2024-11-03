package com.jarmison.manager.repository;

import com.jarmison.manager.entity.cadastros.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
    @Query("SELECT v FROM Vendedor v JOIN FETCH v.colaborador c JOIN FETCH c.pessoa p WHERE LOWER(p.nome) = LOWER(:nome)")
    List<Vendedor> buscarVendedor(@Param("nome") String nome);
}
