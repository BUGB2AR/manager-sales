package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Transportadora;
import com.jarmison.manager.repository.TransportadoraRepository;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class TransportadoraStrategyImpl implements TransportadoraStrategy {

    private final TransportadoraRepository transportadoraRepository;

    public TransportadoraStrategyImpl(TransportadoraRepository transportadoraRepository) {
        this.transportadoraRepository = transportadoraRepository;
    }

    @Override
    public List<Transportadora> buscarTransportadora(String nome) {
        return transportadoraRepository.buscarTransportadora(nome);
    }
}
