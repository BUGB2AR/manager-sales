package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Colaborador;

import java.util.List;

public interface ColaboradorStrategy {
    List<Colaborador>buscarColaboradores(String nome);
}
