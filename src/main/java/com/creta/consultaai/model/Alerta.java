package com.creta.consultaai.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Data
public class Alerta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotBlank(message = "Nome do Hospital é obrigatório")
    private String nome;

    @NotBlank(message = "Nome do Hospital é obrigatório")
    private String descricao;

    public Alerta(){ }

    public Alerta(@NotBlank String nome, @NotBlank String descricao) {
        super();
        this.nome = nome;
        this.descricao = descricao;
    }


    public Alerta(String nome) {
        this.nome = nome;
    }
}
