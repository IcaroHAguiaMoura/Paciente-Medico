package com.curso.services;

import com.curso.domains.Medico;
import com.curso.domains.Paciente;
import com.curso.domains.enums.Status;
import com.curso.repositories.MedicoRepository;
import com.curso.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class DBService {
    @Autowired
    private PacienteRepository pacienteRepo;

    @Autowired
    private MedicoRepository medicoRepo;

    public void initDB() {
        Medico medico01 = new Medico(null, "Balestrin", LocalDate.now(),
                new BigDecimal("7500.00"));
        Medico medico02 = new Medico(null, "Cariani", LocalDate.now(),
                new BigDecimal("15000.00"));

        medicoRepo.save(medico01);
        medicoRepo.save(medico02);

        Paciente paciente01 = new Paciente(null, "Icaro", LocalDate.now(),
                new BigDecimal("800.00"), Status.ALTA, medico01);
        Paciente paciente02 = new Paciente(null, "Paçoquinha", LocalDate.now(),
                new BigDecimal("1200.00"), Status.INTERNADO, medico02);

        pacienteRepo.save(paciente01);
        pacienteRepo.save(paciente02);
    }
}
