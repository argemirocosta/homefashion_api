package br.com.homefashion.api.resources;

import br.com.homefashion.api.domain.Cliente;
import br.com.homefashion.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/servidor", method = RequestMethod.GET)
    public String testarServidor() {
        return "Servidor no ar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Cliente>> listar(@RequestParam int pagina, @RequestParam int qtd) {

        Pageable paginacao = PageRequest.of(pagina, qtd);

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar(paginacao));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente;
        cliente = clienteService.buscar(id);

        CacheControl cacheControl = CacheControl.maxAge(1, TimeUnit.MINUTES);

        return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(cliente);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente) {

        cliente = clienteService.salvar(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Cliente cliente, @PathVariable("id") Integer id) {
        cliente.setId(id);
        clienteService.alterar(cliente);

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/usuario/{codigoUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listarClientesPorUsuario(@PathVariable("codigoUsuario") Integer codigoUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.consultarClientesPorUsuario(codigoUsuario));
    }

    @RequestMapping(value = "/usuario/nome/{nomeUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listarClientesPorNomeUsuario(@PathVariable("nomeUsuario") String nomeUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.consultarClientesPorNomeUsuario(nomeUsuario));
    }
}
