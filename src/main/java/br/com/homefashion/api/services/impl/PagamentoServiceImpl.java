package br.com.homefashion.api.services.impl;

import br.com.homefashion.api.domain.Pagamento;
import br.com.homefashion.api.repository.PagamentoRepository;
import br.com.homefashion.api.services.PagamentoService;
import br.com.homefashion.api.services.exceptions.PagamentoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagamentoServiceImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Override
    public List<Pagamento> listar() {
        return pagamentoRepository.findAll();
    }

    @Override
    public Optional<Pagamento> buscar(Integer id) {
        Optional<Pagamento> pagamento = pagamentoRepository.findById(id);

        if (pagamento.isEmpty()) {
            throw new PagamentoNaoEncontradoException();
        }

        return pagamento;
    }

    @Override
    public Pagamento salvar(Pagamento pagamento) {
        pagamento.setId(null);

        return pagamentoRepository.save(pagamento);

    }

    @Override
    public List<Pagamento> consultarPagamentosPorVenda(Integer codigoVenda) {
        return pagamentoRepository.consultarPagamentosPorVenda(codigoVenda);
    }

    @Override
    public List<Pagamento> consultarPagamentosPorCliente(Integer codigoCliente) {
        return pagamentoRepository.consultarPagamentosPorCliente(codigoCliente);
    }

    @Override
    public void cancelarPagamento(Integer codigoPagamento){
        verificarSePagamentoExiste(codigoPagamento);
        pagamentoRepository.cancelarPagamento(codigoPagamento);
    }

    private void verificarSePagamentoExiste(Integer codigoPagamento){
        buscar(codigoPagamento);
    }

}
