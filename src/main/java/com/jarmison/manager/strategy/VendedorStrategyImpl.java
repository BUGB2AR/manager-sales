package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Vendedor;
import com.jarmison.manager.repository.VendedorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VendedorStrategyImpl implements VendedorStrategy {
    private final VendedorRepository vendedorRepository;

    public VendedorStrategyImpl(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @Override
    public List<Vendedor> buscarVendedor(String nome) {
        return vendedorRepository.buscarVendedor(nome);
    }
}
