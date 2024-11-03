package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.vendas.VendaCabecalho;
import com.jarmison.manager.entity.vendas.VendaDetalhe;
import com.jarmison.manager.entity.vendas.VendaOrcamentoCabecalho;

import java.util.List;

public interface VendaStrategy {
    void incluiVenda(Integer numeroFatura, VendaCabecalho vendaCabecalho);
    void carregarOrcamentosVendas(Integer orcamentoId);
    List<VendaCabecalho> buscarVendas();

    List<VendaOrcamentoCabecalho> buscarVendaOrcamentoCabecalho(String codigo);

}
