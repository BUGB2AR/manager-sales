package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Produto;
import com.jarmison.manager.repository.ProdutoRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProdutoStrategyImpl implements ProdutoStrategy {
    private final ProdutoRepository produtoRepository;

    public ProdutoStrategyImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> buscarProdutos(String nome) {
        return produtoRepository.findProdutoByNome(nome);
    }

}
