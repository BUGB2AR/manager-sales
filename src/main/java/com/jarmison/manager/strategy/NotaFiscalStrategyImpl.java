package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.vendas.NotaFiscalTipo;
import com.jarmison.manager.repository.NotaFiscalTipoRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NotaFiscalStrategyImpl implements NotaFiscalStrategy {
    private final NotaFiscalTipoRepository notaFiscalTipoRepository;

    public NotaFiscalStrategyImpl(NotaFiscalTipoRepository notaFiscalTipoRepository) {
        this.notaFiscalTipoRepository = notaFiscalTipoRepository;
    }

    @Override
    public List<NotaFiscalTipo> buscarTipoNotaFiscal(String nome) {
        return notaFiscalTipoRepository.buscarNotaFiscalTipo(nome);
    }
}
