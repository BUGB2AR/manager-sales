package com.jarmison.manager.strategy;

import com.jarmison.manager.entity.cadastros.Colaborador;
import com.jarmison.manager.repository.ColaboradorRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColaboradorStrategyImpl implements ColaboradorStrategy {

    private final ColaboradorRepository colaboradorRepository;

    public ColaboradorStrategyImpl(ColaboradorRepository repository) {
        this.colaboradorRepository = repository;
    }

    @Override
    public List<Colaborador> buscarColaboradores(String nome) {
        return colaboradorRepository.findColaboradorByNome(nome);
    }
}
