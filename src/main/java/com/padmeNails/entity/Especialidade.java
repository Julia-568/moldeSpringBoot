package com.padmeNails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "especialidade")
public class Especialidade {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEspecialidade;

    @Column(nullable = false, length = 100)
    private String tipoEspecialidade;

    @Column(nullable = false, length = 255)
    private String descricaoEspecialidade;

    public Especialidade() {
    }

    public Long getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Long idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getTipoEspecialidade() {
        return tipoEspecialidade;
    }

    public void setTipoEspecialidade(String tipoEspecialidade) {
        this.tipoEspecialidade = tipoEspecialidade;
    }

    public String getDescricaoEspecialidade() {
        return descricaoEspecialidade;
    }

    public void setDescricaoEspecialidade(String descricaoEspecialidade) {
        this.descricaoEspecialidade = descricaoEspecialidade;
    }
}
