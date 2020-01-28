package br.com.homefashion.api.services;

import br.com.homefashion.api.domain.Pagamento;

import java.util.List;
import java.util.Optional;

public interface PagamentoService {

    List<Pagamento> listar();

    Optional<Pagamento> buscar(Integer id);

    Pagamento salvar(Pagamento pagamento);

    List<Pagamento> consultarPagamentosPorCliente(Integer codigoCliente);

    List<Pagamento> consultarPagamentosPorVenda(Integer codigoVenda);

    void cancelarPagamento(Integer codigoPagamento);
}
