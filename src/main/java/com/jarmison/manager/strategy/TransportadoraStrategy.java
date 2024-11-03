package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Transportadora;
import java.util.List;

public interface TransportadoraStrategy {
    List<Transportadora> buscarTransportadora(String nome);
}
