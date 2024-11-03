package com.jarmison.manager.resource;

import com.jarmison.manager.entity.cadastros.Colaborador;
import com.jarmison.manager.entity.cadastros.Produto;
import com.jarmison.manager.entity.cadastros.Transportadora;
import com.jarmison.manager.entity.cadastros.Vendedor;
import com.jarmison.manager.entity.vendas.CondicoesPagamento;
import com.jarmison.manager.entity.vendas.NotaFiscalTipo;
import com.jarmison.manager.service.CadastroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cadastro")
public class CadastroResource {
    private final CadastroService cadastroService;

    @Autowired
    public CadastroResource(CadastroService cadastroService) {
        this.cadastroService = cadastroService;
    }

    @GetMapping("/buscar-colaboradores")
    public ResponseEntity<List<Colaborador>> buscarColaboradores(@RequestParam(required = false) String nome) {
        List<Colaborador> buscar = cadastroService.buscarColaboradores(nome);

        if (buscar.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/buscar-vendedores")
    public ResponseEntity<List<Vendedor>> buscarVendedores(@RequestParam(required = false) String nome) {
        List<Vendedor> buscar = cadastroService.buscarVendedores(nome);

        if (buscar.isEmpty()) {
            ResponseEntity.notFound();
        }
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/buscar-produtos")
    public ResponseEntity<List<Produto>> buscarProdutos(@RequestParam(required = false) String nome) {
        List<Produto> buscar = cadastroService.buscarProdutos(nome);

        if (buscar.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/buscar-tiponota")
    public ResponseEntity<List<NotaFiscalTipo>> buscarTipoNotaFiscal(@RequestParam(required = false) String nome) {
        List<NotaFiscalTipo> buscar = cadastroService.buscarTipoNotaFiscal(nome);

        if (buscar.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/buscar-transportadora")
    public ResponseEntity<List<Transportadora>> buscarTransportadora(@RequestParam(required = false) String nome) {
        List<Transportadora> buscar = cadastroService.buscarTransportadora(nome);

        if (buscar.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscar);
    }

    @GetMapping("/buscar-condicoes-pagamento")
    public ResponseEntity<List<CondicoesPagamento>> buscarCondicoesPagamento(@RequestParam(required = false) String nome) {
        List<CondicoesPagamento> buscar = cadastroService.buscarCondicoesDePagamento(nome);

        if (buscar.isEmpty()) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buscar);
    }
}
