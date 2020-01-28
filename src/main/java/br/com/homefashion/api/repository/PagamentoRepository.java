package br.com.homefashion.api.repository;

import br.com.homefashion.api.domain.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

import static br.com.homefashion.api.shared.Queries.*;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

    @Query(CONSULTA_PAGAMENTOS_POR_VENDA)
    List<Pagamento> consultarPagamentosPorVenda(@Param("codigoVenda") Integer codigoVenda);

    @Query(value = CONSULTA_PAGAMENTOS_POR_CLIENTE, nativeQuery = true)
    List<Pagamento> consultarPagamentosPorCliente(@Param("codigoCliente") Integer codigoCliente);

    @Modifying
    @Transactional
    @Query(value = ALTERAR_CANCELAR_PAGAMENTO, nativeQuery = true)
    void cancelarPagamento(@Param("codigoPagamento") Integer codigoPagamento);

}
