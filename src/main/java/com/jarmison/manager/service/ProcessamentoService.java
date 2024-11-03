package com.jarmison.manager.service;

import com.jarmison.manager.entity.vendas.VendaCabecalho;
import com.jarmison.manager.entity.vendas.VendaDetalhe;
import com.jarmison.manager.utils.MathUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProcessamentoService {

    public void processaTotais(VendaCabecalho vendaCabecalho) {
        BigDecimal subTotal = BigDecimal.ZERO;
        BigDecimal totalDesconto = BigDecimal.ZERO;

        for (VendaDetalhe d : vendaCabecalho.getListaVendaDetalhe()) {
            d.setValorComissao(MathUtils.soma(subTotal, d.getValorSubtotal()));

            if (d.getTaxaDesconto() != null) {
                d.setValorDesconto(
                        MathUtils.multiplica(d.getValorSubtotal(),
                                MathUtils.divide(d.getTaxaDesconto(), BigDecimal.valueOf(100))));
            }

            if (d.getValorDesconto() != null) {
                totalDesconto = MathUtils.soma(totalDesconto, d.getValorDesconto());
                d.setValorDesconto(
                        MathUtils.subtrai(d.getValorSubtotal(),
                                d.getValorDesconto()));
            } else {
                d.setValorTotal(d.getValorSubtotal());
            }
        }
        vendaCabecalho.setValorSubtotal(subTotal);

        if (totalDesconto.compareTo(BigDecimal.ZERO) != 0) {

            vendaCabecalho.setValorDesconto(totalDesconto);
            vendaCabecalho.setTaxaDesconto(
                    MathUtils.multiplica(
                            MathUtils.divide(totalDesconto, subTotal), BigDecimal.valueOf(100)));
        }

        vendaCabecalho.setValorTotal(subTotal);

        if (vendaCabecalho.getValorFrete() != null) {
            vendaCabecalho.setValorTotal(MathUtils.soma(vendaCabecalho.getValorTotal(), vendaCabecalho.getValorFrete()));
        }

        if (vendaCabecalho.getValorDesconto() != null) {
            vendaCabecalho.setValorTotal(MathUtils.subtrai(vendaCabecalho.getValorTotal(), vendaCabecalho.getValorDesconto()));
        }

        if (vendaCabecalho.getTaxaComissao() != null) {
            vendaCabecalho.setValorComissao(
                    MathUtils.multiplica(
                            MathUtils.subtrai(subTotal, totalDesconto),
                            MathUtils.divide(vendaCabecalho.getTaxaComissao(), BigDecimal.valueOf(100))));
        }

        atualizaValoresVendaOrcamento(vendaCabecalho);
    }

     public void atualizaValoresVendaOrcamento(VendaCabecalho vendaCabecalho) {
        if (vendaCabecalho.getValorSubtotal() != null) {
            if (vendaCabecalho.getTaxaDesconto() != null) {
                vendaCabecalho.setValorDesconto(MathUtils.multiplica(vendaCabecalho.getValorSubtotal(), MathUtils.divide(vendaCabecalho.getTaxaDesconto(), BigDecimal.valueOf(100))));
                vendaCabecalho.setValorTotal(MathUtils.subtrai(vendaCabecalho.getValorSubtotal(), vendaCabecalho.getValorDesconto()));
            }
            if (vendaCabecalho.getValorFrete() != null) {
                if (vendaCabecalho.getValorTotal() == null) {
                    vendaCabecalho.setValorTotal(vendaCabecalho.getValorSubtotal());
                }
                vendaCabecalho.setValorTotal(MathUtils.soma(vendaCabecalho.getValorTotal(), vendaCabecalho.getValorFrete()));
            }
        }
    }

}
