package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Vendedor;
import java.util.List;

public interface VendedorStrategy {
    List<Vendedor> buscarVendedor(String nome);
}
