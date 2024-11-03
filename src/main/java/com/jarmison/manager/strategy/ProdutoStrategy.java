package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Produto;
import java.util.List;

public interface ProdutoStrategy {
    List<Produto> buscarProdutos(String nome);
}
