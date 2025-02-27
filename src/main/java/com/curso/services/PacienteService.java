package com.curso.services;

import com.curso.domains.Paciente;
import com.curso.domains.dtos.PacienteDTO;
import com.curso.repositories.PacienteRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepo;

    public List<PacienteDTO> findAll(){
        return pacienteRepo.findAll().stream().map(obj -> new PacienteDTO(obj)).
                collect(Collectors.toList());
    }

    public Paciente findbyId(Long id){
        Optional<Paciente> obj = pacienteRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Paciente não encontrado! Id: "+id));
    }

    public Paciente create(PacienteDTO dto){
        dto.setId(null);
        Paciente obj = new Paciente(dto);
        return pacienteRepo.save(obj);
    }

    public Paciente update(Long id, PacienteDTO objDto){
        objDto.setId(id);
        Paciente oldObj = findbyId(id);
        oldObj = new Paciente(objDto);
        return pacienteRepo.save(oldObj);
    }

    public void delete(Long id){
        Paciente obj = findbyId(id);
        pacienteRepo.deleteById(id);
    }
    
}

