package com.padmeNails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.padmeNails.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
