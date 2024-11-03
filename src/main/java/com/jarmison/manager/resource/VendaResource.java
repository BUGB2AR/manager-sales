package com.jarmison.manager.resource;
import com.jarmison.manager.entity.vendas.VendaCabecalho;
import com.jarmison.manager.entity.vendas.VendaOrcamentoCabecalho;
import com.jarmison.manager.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaResource {

    private final VendaService vendaService;

    @Autowired
    public VendaResource(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping("/incluir")
    public ResponseEntity<String> incluirVenda(@RequestParam Integer numeroFatura,
                                               @RequestBody VendaCabecalho vendaCabecalho) {
        try {
            vendaService.processarVenda(numeroFatura, vendaCabecalho);

            return new ResponseEntity<>("Venda incluída com sucesso para a fatura "
                    + numeroFatura + ", com data de venda: "
                    + vendaCabecalho.getDataVenda(), HttpStatus.CREATED);

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/buscar-vendas")
    public ResponseEntity<List<VendaCabecalho>> buscarVendas() {
        List<VendaCabecalho> vendas = vendaService.buscarVendas();

        if (vendas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/buscar-vendas-orcamento")
    public ResponseEntity<List<VendaOrcamentoCabecalho>> buscarVendasOrcamentoCabecalho(@RequestParam String codigo) {
        List<VendaOrcamentoCabecalho> vendas = vendaService.buscarVendaOracamentoCabecalho(codigo);

        if (vendas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(vendas);
    }
}
