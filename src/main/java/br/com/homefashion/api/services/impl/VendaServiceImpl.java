package br.com.homefashion.api.services.impl;

import br.com.homefashion.api.domain.Venda;
import br.com.homefashion.api.repository.VendaRepository;
import br.com.homefashion.api.services.VendaService;
import br.com.homefashion.api.services.exceptions.VendaNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaServiceImpl implements VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    public Optional<Venda> buscar(Integer id){
        Optional<Venda> venda = vendaRepository.findById(id);

        if(venda.isEmpty()){
            throw new VendaNaoEncontradaException();
        }

        return venda;
    }

    public Venda salvar(Venda venda){
        venda.setId(null);

        return vendaRepository.save(venda);

    }

    public List<Venda> consultarVendasPorUsuario(Integer codigoUsuario) {
        return vendaRepository.consultarVendasPorUsuario(codigoUsuario);
    }

    public void cancelarVenda(Integer codigoVenda){
        verificarSeVendaExiste(codigoVenda);
        vendaRepository.cancelarVenda(codigoVenda);
    }

    private void verificarSeVendaExiste(Integer codigoVenda){
        buscar(codigoVenda);
    }

}
