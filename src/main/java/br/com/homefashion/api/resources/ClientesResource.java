package br.com.homefashion.api.resources;

import br.com.homefashion.api.domain.Cliente;
import br.com.homefashion.api.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesResource {

    @Autowired
    private ClientesRepository clientesRepository;

    @RequestMapping(value = "/servidor", method = RequestMethod.GET)
    public String testarServidor(){
        return "Servidor no ar";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(clientesRepository.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> salvar(@RequestBody Cliente cliente){
        cliente = clientesRepository.save(cliente);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> buscar(@PathVariable("id") Integer id){
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if(cliente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não cadastrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable("id") Integer id){
        try {
            clientesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> alterar(@RequestBody Cliente cliente, @PathVariable("id") Integer id){
        cliente.setId(id);
        clientesRepository.save(cliente);

        return ResponseEntity.noContent().build();
    }
}
