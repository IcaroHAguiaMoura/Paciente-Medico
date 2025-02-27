package com.curso.domains;

import com.curso.domains.dtos.PacienteDTO;
import com.curso.domains.enums.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
    private Long id;

    @NotNull
    @NotBlank
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal custoInternacao;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O status do filme nao pode ser nulo")
    private Status status;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    public Paciente() {

    }

    public Paciente(Long id, String nome, LocalDate dataNascimento, BigDecimal custoInternacao, Status status, Medico medico) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.custoInternacao = custoInternacao;
        this.status = status;
        this.medico = medico;
    }

    public Paciente(PacienteDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.custoInternacao = dto.getCustoInternacao();
        this.medico = new Medico(dto.getMedico());
        this.status = dto.getStatus();


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @NotBlank String getNome() {
        return nome;
    }

    public void setNome(@NotNull @NotBlank String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotNull @Digits(integer = 15, fraction = 3) BigDecimal getCustoInternacao() {
        return custoInternacao;
    }

    public void setCustoInternacao(@NotNull @Digits(integer = 15, fraction = 3) BigDecimal custoInternacao) {
        this.custoInternacao = custoInternacao;
    }

    public @NotNull(message = "O status do filme nao pode ser nulo") Status getStatus() {
        return status;
    }

    public void setStatus(@NotNull(message = "O status do filme nao pode ser nulo") Status status) {
        this.status = status;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
}
