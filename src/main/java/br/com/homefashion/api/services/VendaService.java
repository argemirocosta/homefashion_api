package br.com.homefashion.api.services;

import br.com.homefashion.api.domain.Venda;
import br.com.homefashion.api.repository.VendaRepository;
import br.com.homefashion.api.services.exceptions.ClienteNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscar(Integer id){
        Optional<Venda> venda = vendaRepository.findById(id);

        if(venda.isEmpty()){
            throw new ClienteNaoEncontradoException();
        }

        return venda;
    }

    public Venda salvar(Venda venda){
        venda.setId(null);

        return vendaRepository.save(venda);

    }

    public void deletar(Integer id){
        try {
            vendaRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ClienteNaoEncontradoException();
        }
    }

    public void alterar(Venda venda){
        verificarSeVendaExiste(venda);
        vendaRepository.save(venda);
    }

    private void verificarSeVendaExiste(Venda venda){
        buscar(venda.getId());
    }

}
