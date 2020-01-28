package br.com.homefashion.api.repository;

import br.com.homefashion.api.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
