package com.curso.domains.dtos;

import com.curso.domains.Medico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MedicoDTO {
    private Long id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao;

    @NotNull(message = "O campo salario nao pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal salario;

    public MedicoDTO() {
    }

    public MedicoDTO(Medico medico) {
        this.id = medico.getId();
        this.nome = medico.getNome();
        this.dataContratacao = medico.getDataContratacao();
        this.salario = medico.getSalario();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String getNome() {
        return nome;
    }

    public void setNome(@NotNull(message = "O campo nome não pode ser nulo") @NotBlank(message = "O campo nome não pode estar vazio") String nome) {
        this.nome = nome;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public @NotNull(message = "O campo salario nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O campo salario nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal salario) {
        this.salario = salario;
    }
}
