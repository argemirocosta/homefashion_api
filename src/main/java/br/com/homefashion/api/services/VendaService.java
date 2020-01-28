package br.com.homefashion.api.services;

import br.com.homefashion.api.domain.Venda;

import java.util.List;
import java.util.Optional;

public interface VendaService {

    List<Venda> listar();

    Optional<Venda> buscar(Integer id);

    Venda salvar(Venda venda);

    void deletar(Integer id);

    void alterar(Venda venda);

    List<Venda> consultarVendasPorUsuario(Integer codigoUsuario);
}
