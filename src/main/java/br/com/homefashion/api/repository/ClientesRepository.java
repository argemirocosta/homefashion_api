package br.com.homefashion.api.repository;

import br.com.homefashion.api.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
}
