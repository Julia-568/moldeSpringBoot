package com.padmeNails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.padmeNails.entity.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
