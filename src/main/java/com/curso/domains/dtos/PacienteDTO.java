package com.curso.domains.dtos;

import com.curso.domains.Paciente;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.curso.domains.Medico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PacienteDTO {

    private Long id;

    @NotNull(message = "O campo nome não pode ser nulo")
    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull(message = "O campo custoInternacao nao pode ser nulo")
    @Digits(integer = 15, fraction = 3)
    private BigDecimal custoInternacao;

    @NotNull(message = "O medico nao esta disponivel")
    private MedicoDTO medico;

    @NotNull(message = "O status do paciente nao pode ser nulo")
    private Status status;


    public PacienteDTO() {
    }

    public PacienteDTO(Paciente paciente) {
        this.id = paciente.getId();
        this.nome = paciente.getNome();
        this.dataNascimento = paciente.getDataNascimento();
        this.custoInternacao = paciente.getCustoInternacao();
        this.status = paciente.getStatus();
        if(paciente.getMedico()!= null){
            this.medico = new MedicoDTO(paciente.getMedico());
        }


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

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull(message = "O campo custoInternacao nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(@NotNull(message = "O campo custoInternacao nao pode ser nulo") @Digits(integer = 15, fraction = 3) BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public @NotNull(message = "O status do paciente nao pode ser nulo") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "O status do paciente nao pode ser nulo") Status status) {
        this.status = status;
    }

    public @NotNull(message = "O medico nao esta disponivel") MedicoDTO getMedico() {
        return medico;
    }

    public void setMedico(@NotNull(message = "O medico nao esta disponivel") MedicoDTO medico) {
        this.medico = medico;
    }
}
