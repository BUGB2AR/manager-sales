package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.vendas.CondicoesPagamento;
import com.jarmison.manager.repository.CondicoesPagamentoRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CondicoesPagamentoStrategyImpl implements CondicoesPagamentoStrategy {

    private final CondicoesPagamentoRepository condicoesPagamentoRepository;

    public CondicoesPagamentoStrategyImpl(CondicoesPagamentoRepository condicoesPagamentoRepository) {
        this.condicoesPagamentoRepository = condicoesPagamentoRepository;
    }

    @Override
    public List<CondicoesPagamento> buscarCondicoesPagamento(String nome) {
        return condicoesPagamentoRepository.buscarCondicoesPagamento(nome);
    }


}
