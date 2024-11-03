package com.jarmison.manager.service;

import com.jarmison.manager.entity.cadastros.Colaborador;
import com.jarmison.manager.entity.cadastros.Produto;
import com.jarmison.manager.entity.cadastros.Transportadora;
import com.jarmison.manager.entity.cadastros.Vendedor;
import com.jarmison.manager.entity.vendas.CondicoesPagamento;
import com.jarmison.manager.entity.vendas.NotaFiscalTipo;
import com.jarmison.manager.strategy.*;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CadastroService {

    private final Map<String, ColaboradorStrategy> colaboradorStrategyMap;

    private final Map<String, ProdutoStrategy> produtoStrategyMap;

    private final Map<String, VendedorStrategy> vendedorStrategyMap;

    private final Map<String, NotaFiscalStrategy> notaFiscalStrategyMap;

    private final Map<String, TransportadoraStrategy> transportadoraStrategyMap;

    private final Map<String, CondicoesPagamentoStrategy> condicoesPagamentoStrategyMap;

    private static final String COLABORADOR_PESQUISA = "ColaboradorStrategyImpl";

    private static final String PRODUTO_PESQUISA = "ProdutoStrategyImpl";

    private static final String VENDEDOR_PESQUISA = "VendedorStrategyImpl";

    private static final String TIPO_NOTA_FISCAL_PESQUISA = "NotaFiscalStrategyImpl";

    private static final String TRANSPORTADORA_PESQUISA = "TransportadoraStrategyImpl";

    private static final String CONDICOES_PAGAMENTO_PESQUISA = "CondicoesPagamentoStrategyImpl";

    public CadastroService(List<ColaboradorStrategy> strategyList,
                           List<ProdutoStrategy> produtoStrategyList,
                           List<VendedorStrategy> vendedorStrategyList,
                           List<NotaFiscalStrategy> notaFiscalStrategyMap,
                           List<TransportadoraStrategy> transportadoraStrategyMap,
                           List<CondicoesPagamentoStrategy> condicoesPagamentoStrategyMap) {

        this.colaboradorStrategyMap = strategyList.stream()
                .collect(Collectors.toMap(
                        strategy -> strategy.getClass().getSimpleName(),
                        strategy -> strategy));

        this.produtoStrategyMap = produtoStrategyList.stream()
                .collect(Collectors.toMap(
                         strategy -> strategy.getClass().getSimpleName(),
                         strategy -> strategy));

        this.vendedorStrategyMap = vendedorStrategyList.stream()
                .collect(Collectors.toMap(
                        strategy -> strategy.getClass().getSimpleName(),
                        strategy -> strategy));

        this.notaFiscalStrategyMap = notaFiscalStrategyMap.stream()
                .collect(Collectors.toMap(
                        strategy -> strategy.getClass().getSimpleName(),
                        strategy -> strategy));

        this.transportadoraStrategyMap = transportadoraStrategyMap.stream()
                .collect(Collectors.toMap(
                        strategy -> strategy.getClass().getSimpleName(),
                        strategy -> strategy));

        this.condicoesPagamentoStrategyMap = condicoesPagamentoStrategyMap.stream()
                .collect(Collectors.toMap(
                        strategy -> strategy.getClass().getSimpleName(),
                        strategy -> strategy));
    }

    public List<Colaborador> buscarColaboradores(String nome) {
        ColaboradorStrategy strategy = colaboradorStrategyMap.get(COLABORADOR_PESQUISA);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia de listagem não suportada.");
        }
        return strategy.buscarColaboradores(nome);
    }

    public List<CondicoesPagamento> buscarCondicoesDePagamento(String nome) {
        CondicoesPagamentoStrategy strategy = condicoesPagamentoStrategyMap.get(CONDICOES_PAGAMENTO_PESQUISA);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia de listagem não suportada.");
        }
        return strategy.buscarCondicoesPagamento(nome);
    }

    public List<Produto> buscarProdutos(String nome) {
        ProdutoStrategy strategy = produtoStrategyMap.get(PRODUTO_PESQUISA);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia de listagem não suportada.");
        }
        return strategy.buscarProdutos(nome);
    }

    public List<Transportadora> buscarTransportadora(String nome) {
        TransportadoraStrategy strategy = transportadoraStrategyMap.get(TRANSPORTADORA_PESQUISA);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia de listagem não suportada.");
        }
        return strategy.buscarTransportadora(nome);
    }

    public List<NotaFiscalTipo> buscarTipoNotaFiscal(String nome) {
        NotaFiscalStrategy strategy = notaFiscalStrategyMap.get(TIPO_NOTA_FISCAL_PESQUISA);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia de listagem não suportada.");
        }
        return strategy.buscarTipoNotaFiscal(nome);
    }

    public List<Vendedor> buscarVendedores(String nome) {
        VendedorStrategy strategy = vendedorStrategyMap.get(VENDEDOR_PESQUISA);
        if (strategy == null) {
            throw new IllegalArgumentException("Estratégia de listagem não suportada.");
        }
        return strategy.buscarVendedor(nome);
    }
}
