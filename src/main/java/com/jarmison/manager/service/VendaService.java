package com.jarmison.manager.service;

import com.jarmison.manager.entity.vendas.VendaCabecalho;
import com.jarmison.manager.entity.vendas.VendaDetalhe;
import com.jarmison.manager.entity.vendas.VendaOrcamentoCabecalho;
import com.jarmison.manager.strategy.VendaStrategy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VendaService {

    private final Map<String, VendaStrategy> vendaStrategy;
    public static final String VENDA_STRATEGY = "VendaStrategyImpl";
    private static final String MSG_STRATEGY_NOT_FOUND = "Estratégia de venda não suportada";

    public VendaService(List<VendaStrategy> strategyList) {
      vendaStrategy = strategyList.stream()
              .collect(Collectors.toMap(
                      strategy -> strategy.getClass().getSimpleName(),
                      strategy -> strategy));
    }

    public void processarVenda(Integer numeroFatura, VendaCabecalho vendaCabecalho) {
        VendaStrategy strategy = vendaStrategy.get(VENDA_STRATEGY);

        if (strategy != null) {
            strategy.incluiVenda(numeroFatura, vendaCabecalho);
        } else {
            throw new IllegalArgumentException(MSG_STRATEGY_NOT_FOUND + numeroFatura);
        }
    }

    public void processarVendaOrcamento(Integer orcamentoId) {
        VendaStrategy strategy = vendaStrategy.get(VENDA_STRATEGY);

        if (strategy != null ) {
            strategy.carregarOrcamentosVendas(orcamentoId);
        } else {
            throw new IllegalArgumentException(MSG_STRATEGY_NOT_FOUND);
        }
    }


    public List<VendaCabecalho> buscarVendas() {
        VendaStrategy strategy = vendaStrategy.get(VENDA_STRATEGY);

        if (strategy != null) {
            return strategy.buscarVendas();
        } else {
            throw new IllegalArgumentException(MSG_STRATEGY_NOT_FOUND);
        }
    }

    public List<VendaOrcamentoCabecalho> buscarVendaOracamentoCabecalho(String codigo) {
        VendaStrategy strategy = vendaStrategy.get(VENDA_STRATEGY);
        if (strategy != null) {
            return strategy.buscarVendaOrcamentoCabecalho(codigo);
        } else {
            throw new IllegalArgumentException(MSG_STRATEGY_NOT_FOUND);
        }
    }

}
