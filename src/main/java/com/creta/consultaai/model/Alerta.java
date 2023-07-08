package com.creta.consultaai.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

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
