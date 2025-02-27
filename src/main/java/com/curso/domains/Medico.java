package com.curso.domains;

import com.curso.domains.dtos.MedicoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "medico")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_medico")
    private Long id;

    @NotNull @NotBlank
    private String nome;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataContratacao;

    @NotNull
    @Digits(integer = 15, fraction = 3)
    private BigDecimal salario;

    @OneToMany(mappedBy = "medico")
    private List<Paciente> pacientes;

    public Medico() {
    }

    public Medico(MedicoDTO dto) {
        this.id = dto.getId();
        this.nome = dto.getNome();
        this.dataContratacao = dto.getDataContratacao();
        this.salario = dto.getSalario();
    }

    public Medico(Long id, String nome, LocalDate dataContratacao, BigDecimal salario) {
        this.id = id;
        this.nome = nome;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
}
