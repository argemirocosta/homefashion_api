package br.com.homefashion.api.repository;

import br.com.homefashion.api.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import static br.com.homefashion.api.shared.Queries.CONSULTA_CLIENTES_POR_USUARIO;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query(CONSULTA_CLIENTES_POR_USUARIO)
    List<Cliente> consultarClientesPorUsuario(@Param("codigoUsuario") Integer codigoUsuario);
}
