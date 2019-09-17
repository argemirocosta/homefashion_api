package br.com.homefashion.api.services;

import br.com.homefashion.api.domain.Cliente;
import br.com.homefashion.api.repository.ClientesRepository;
import br.com.homefashion.api.services.exceptions.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Cliente> listar(){
        return clientesRepository.findAll();
    }

    public Optional<Cliente> buscar(Integer id){
        Optional<Cliente> cliente = clientesRepository.findById(id);

        if(cliente.isEmpty()){
            throw new ClienteNaoEncontradoException("Cliente não encontrado!");
        }

        return cliente;
    }

    public Cliente salvar(Cliente cliente){
        cliente.setId(null);

        return clientesRepository.save(cliente);

    }

    public void deletar(Integer id){
        try {
            clientesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ClienteNaoEncontradoException("Cliente não encontrado!");
        }
    }

    public void alterar(Cliente cliente){
        verificarSeClienteExiste(cliente);
        clientesRepository.save(cliente);
    }

    private void verificarSeClienteExiste(Cliente cliente){
        buscar(cliente.getId());
    }

}
