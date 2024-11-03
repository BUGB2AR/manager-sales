package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.vendas.CondicoesPagamento;

import java.util.List;

public interface CondicoesPagamentoStrategy {
    List<CondicoesPagamento> buscarCondicoesPagamento(String nome);
}
