package com.padmeNails.entity;

import java.math.BigDecimal;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servico")
public class Servico {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;

    @Column(nullable = false, length = 100)
    private String tipoServico;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal valorServico;

    @Column(nullable = false)
    private LocalTime duracaoServico;

    public Servico() {
    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public void setValorServico(BigDecimal valorServico) {
        this.valorServico = valorServico;
    }

    public LocalTime getDuracaoServico() {
        return duracaoServico;
    }

    public void setDuracaoServico(LocalTime duracaoServico) {
        this.duracaoServico = duracaoServico;
    }
}
