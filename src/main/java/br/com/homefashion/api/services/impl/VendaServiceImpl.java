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

    @Override
    public List<Venda> listar(){
        return vendaRepository.findAll();
    }

    @Override
    public Optional<Venda> buscar(Integer id){
        Optional<Venda> venda = vendaRepository.findById(id);

        if (venda.isPresent()) {
            return venda;
        }
        throw new VendaNaoEncontradaException();

    }

    @Override
    public Venda salvar(Venda venda){
        venda.setId(null);

        return vendaRepository.save(venda);

    }

    @Override
    public List<Venda> consultarVendasPorUsuario(Integer codigoUsuario) {
        return vendaRepository.consultarVendasPorUsuario(codigoUsuario);
    }

    @Override
    public void cancelarVenda(Integer codigoVenda){
        verificarSeVendaExiste(codigoVenda);
        vendaRepository.cancelarVenda(codigoVenda);
    }

    private void verificarSeVendaExiste(Integer codigoVenda){
        buscar(codigoVenda);
    }

}
