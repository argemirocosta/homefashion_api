package br.com.homefashion.api.resources;

import br.com.homefashion.api.domain.Venda;
import br.com.homefashion.api.services.VendaService;
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
@RequestMapping("/venda")
public class VendaResource {

    @Autowired
    private VendaService vendaService;

    @RequestMapping(value = "/servidor", method = RequestMethod.GET)
    public String testarServidor() {
        return "Servidor no ar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Venda>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.listar());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
        Optional<Venda> venda;
        venda = vendaService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(venda);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Venda venda) {

        venda = vendaService.salvar(venda);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venda.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        vendaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Venda venda, @PathVariable("id") Integer id) {
        venda.setId(id);
        vendaService.alterar(venda);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/usuario/{codigoUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Venda>> listarVendasPorUsuario(@PathVariable("codigoUsuario") Integer codigoUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(vendaService.consultarVendasPorUsuario(codigoUsuario));
    }
}
