package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.vendas.NotaFiscalTipo;

import java.util.List;

public interface NotaFiscalStrategy {
    List<NotaFiscalTipo> buscarTipoNotaFiscal(String nome);
}
