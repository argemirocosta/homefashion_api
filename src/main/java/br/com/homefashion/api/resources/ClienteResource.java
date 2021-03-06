package br.com.homefashion.api.resources;

import br.com.homefashion.api.domain.Cliente;
import br.com.homefashion.api.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/servidor", method = RequestMethod.GET)
    public String testarServidor() {
        return "Servidor no ar";
    }

    @Cacheable(value = "listarClientes")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Page<Cliente>> listar(@PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao) {

        return ResponseEntity.status(HttpStatus.OK).body(clienteService.listar(paginacao));
    }

    @Cacheable(value = "buscarCliente")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Integer id) {
        Optional<Cliente> cliente;
        cliente = clienteService.buscar(id);

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value = {"buscarCliente", "listarClientes"}, allEntries = true)
    public ResponseEntity<Void> salvar(@Valid @RequestBody Cliente cliente) {

        cliente = clienteService.salvar(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @CacheEvict(value = {"buscarCliente", "listarClientes"}, allEntries = true)
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @CacheEvict(value = {"buscarCliente", "listarClientes"}, allEntries = true)
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
