package com.padmeNails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "forma_pagamento")
public class FormaPagamento {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFormaPagamento;

    @Column(nullable = false, length = 100)
    private String tipoFormaPagamento;

    public FormaPagamento() {
    }

    public Long getIdFormaPagamento() {
        return idFormaPagamento;
    }

    public void setIdFormaPagamento(Long idFormaPagamento) {
        this.idFormaPagamento = idFormaPagamento;
    }

    public String getTipoFormaPagamento() {
        return tipoFormaPagamento;
    }

    public void setTipoFormaPagamento(String tipoFormaPagamento) {
        this.tipoFormaPagamento = tipoFormaPagamento;
    }
}