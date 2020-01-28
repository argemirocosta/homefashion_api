package br.com.homefashion.api.repository;

import br.com.homefashion.api.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

import static br.com.homefashion.api.shared.Queries.ALTERAR_CANCELAR_VENDA;
import static br.com.homefashion.api.shared.Queries.CONSULTA_VENDAS_POR_USUARIO;

public interface VendaRepository extends JpaRepository<Venda, Integer> {

    @Query(CONSULTA_VENDAS_POR_USUARIO)
    List<Venda> consultarVendasPorUsuario(@Param("codigoUsuario") Integer codigoUsuario);

    @Modifying
    @Transactional
    @Query(value = ALTERAR_CANCELAR_VENDA, nativeQuery = true)
    void cancelarVenda(@Param("codigoVenda") Integer codigoVenda);

}
