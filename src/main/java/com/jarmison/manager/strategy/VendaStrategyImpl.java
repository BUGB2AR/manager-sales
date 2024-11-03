package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.vendas.VendaCabecalho;
import com.jarmison.manager.entity.vendas.VendaDetalhe;
import com.jarmison.manager.entity.vendas.VendaOrcamentoCabecalho;
import com.jarmison.manager.entity.vendas.VendaOrcamentoDetalhe;
import com.jarmison.manager.repository.VendaOrcamentoCabecalhoRepository;
import com.jarmison.manager.repository.VendaCabecalhoRepository;
import com.jarmison.manager.service.ProcessamentoService;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Component
public class VendaStrategyImpl implements VendaStrategy {

    private final VendaCabecalhoRepository vendaCabecalhoRepository;
    private final VendaOrcamentoCabecalhoRepository vendaOrcamentoCabecalhoRepository;

    private final ProcessamentoService processamentoService;

    public VendaStrategyImpl(VendaCabecalhoRepository vendaCabecalhoRepository,
                             VendaOrcamentoCabecalhoRepository vendaOrcamentoCabecalhoRepository, ProcessamentoService processamentoService) {
        this.vendaCabecalhoRepository = vendaCabecalhoRepository;
        this.vendaOrcamentoCabecalhoRepository = vendaOrcamentoCabecalhoRepository;
        this.processamentoService = processamentoService;
    }

    @Override
    public void incluiVenda(Integer numeroFatura, VendaCabecalho vendaCabecalho) {
        if (numeroFatura == null) {
            throw new IllegalArgumentException("Número da fatura não pode ser nulo.");
        }

        Optional<VendaCabecalho> vendaOptional = vendaCabecalhoRepository.findByNumeroFatura(numeroFatura);

        if (vendaOptional.isEmpty()) {
            throw new EntityNotFoundException("Venda não localizada para o número da fatura informada: " + numeroFatura);
        }

        VendaCabecalho vendaEntity = vendaOptional.get();

        if (vendaCabecalho.getVendaRomaneioEntrega() != null) {
            vendaCabecalho.getVendaRomaneioEntrega().getListaVendaCabecalho().add(vendaEntity);
        } else {
            throw new IllegalStateException("VendaRomaneioEntrega não pode ser nulo.");
        }

        vendaCabecalhoRepository.save(vendaCabecalho);
    }

    @Override
    public void carregarOrcamentosVendas(Integer orcamentoId) {
        try {
            VendaOrcamentoCabecalho orcamento = vendaOrcamentoCabecalhoRepository.buscarVendaOrcamentoCabecalho(orcamentoId);
            VendaCabecalho vendaCabecalho = vendaCabecalhoRepository.findByVendaOrcamentoId(orcamentoId);

            vendaCabecalho.setListaVendaDetalhe(new HashSet<>());

            for (VendaOrcamentoDetalhe d : orcamento.getListaVendaOrcamentoDetalhe()) {
                VendaDetalhe itemVenda = new VendaDetalhe();
                itemVenda.setProduto(d.getProduto());
                itemVenda.setQuantidade(d.getQuantidade());
                itemVenda.setTaxaDesconto(d.getTaxaDesconto());
                itemVenda.setValorDesconto(d.getValorDesconto());
                itemVenda.setValorSubtotal(d.getValorSubtotal());
                itemVenda.setValorTotal(d.getValorTotal());
                itemVenda.setValorUnitario(d.getValorUnitario());

                vendaCabecalho.getListaVendaDetalhe().add(itemVenda);
            }

            vendaCabecalho.setCliente(orcamento.getCliente());
            vendaCabecalho.setCondicoesPagamento(orcamento.getCondicoesPagamento());
            vendaCabecalho.setTransportadora(orcamento.getTransportadora());
            vendaCabecalho.setVendedor(orcamento.getVendedor());
            vendaCabecalho.setTipoFrete(orcamento.getTipoFrete());
            vendaCabecalho.setValorSubtotal(orcamento.getValorSubtotal());
            vendaCabecalho.setValorFrete(orcamento.getValorFrete());
            vendaCabecalho.setTaxaComissao(orcamento.getTaxaComissao());
            vendaCabecalho.setValorComissao(orcamento.getValorComissao());
            vendaCabecalho.setTaxaDesconto(orcamento.getValorDesconto());
            vendaCabecalho.setValorTotal(orcamento.getValorTotal());
            vendaCabecalho.setObservacao(orcamento.getObservacao());

            processamentoService.processaTotais(vendaCabecalho);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<VendaCabecalho> buscarVendas() {
        return vendaCabecalhoRepository.findAll();
    }

    @Override
    public List<VendaOrcamentoCabecalho> buscarVendaOrcamentoCabecalho(String codigo) {
        return vendaOrcamentoCabecalhoRepository.buscarVendasOrcamentoCabelhado(codigo);
    }

}
