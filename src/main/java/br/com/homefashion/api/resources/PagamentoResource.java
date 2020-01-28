package br.com.homefashion.api.resources;

import br.com.homefashion.api.domain.Pagamento;
import br.com.homefashion.api.services.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/pagamento")
public class PagamentoResource {

    @Autowired
    private PagamentoService pagamentoService;

    @RequestMapping(value = "/servidor", method = RequestMethod.GET)
    public String testarServidor() {
        return "Servidor no ar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Pagamento>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.listar());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
        Optional<Pagamento> pagamento;
        pagamento = pagamentoService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(pagamento);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Pagamento pagamento) {

        pagamento = pagamentoService.salvar(pagamento);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pagamento.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/venda/{codigoVenda}", method = RequestMethod.GET)
    public ResponseEntity<List<Pagamento>> listarPagamentosPorVenda(@PathVariable("codigoVenda") Integer codigoVenda) {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.consultarPagamentosPorVenda(codigoVenda));
    }

    @RequestMapping(value = "/cliente/{codigoCliente}", method = RequestMethod.GET)
    public ResponseEntity<List<Pagamento>> listarPagamentosPorCliente(@PathVariable("codigoCliente") Integer codigoCliente) {
        return ResponseEntity.status(HttpStatus.OK).body(pagamentoService.consultarPagamentosPorCliente(codigoCliente));
    }

    @RequestMapping(value = "/cancela/{codigoPagamento}", method = RequestMethod.PUT)
    public ResponseEntity<Void> cancelarPagamento(@PathVariable("codigoPagamento") Integer codigoPagamento) {
        pagamentoService.cancelarPagamento(codigoPagamento);

        return ResponseEntity.noContent().build();
    }
}
