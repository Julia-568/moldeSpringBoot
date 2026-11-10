package com.padmeNails.entity;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "profissional")
public class Profissional {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfissional;

    @Column(nullable = false, length = 100)
    private String nomeProfissional;

    @Column(nullable = false, length = 100)
    private String sobrenomeProfissional;

    @Column(nullable = false, length = 20)
    private String telefoneProfissional;

    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidade;

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal comissaoProfissional;

    public Profissional() {
    }

    public Long getIdProfissional() {
        return idProfissional;
    }

    public void setIdProfissional(Long idProfissional) {
        this.idProfissional = idProfissional;
    }

    public String getNomeProfissional() {
        return nomeProfissional;
    }

    public void setNomeProfissional(String nomeProfissional) {
        this.nomeProfissional = nomeProfissional;
    }

    public String getSobrenomeProfissional() {
        return sobrenomeProfissional;
    }

    public void setSobrenomeProfissional(String sobrenomeProfissional) {
        this.sobrenomeProfissional = sobrenomeProfissional;
    }

    public String getTelefoneProfissional() {
        return telefoneProfissional;
    }

    public void setTelefoneProfissional(String telefoneProfissional) {
        this.telefoneProfissional = telefoneProfissional;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public BigDecimal getComissaoProfissional() {
        return comissaoProfissional;
    }

    public void setComissaoProfissional(BigDecimal comissaoProfissional) {
        this.comissaoProfissional = comissaoProfissional;
    }
}
