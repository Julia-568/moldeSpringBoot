package com.padmeNails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.padmeNails.entity.Agendamento;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {

}
