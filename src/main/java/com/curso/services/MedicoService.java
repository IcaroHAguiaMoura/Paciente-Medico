package com.curso.services;

import com.curso.domains.Medico;
import com.curso.domains.dtos.MedicoDTO;
import com.curso.domains.dtos.MedicoDTO;
import com.curso.repositories.MedicoRepository;
import com.curso.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepo;

    public List<MedicoDTO>  findAll(){
        return medicoRepo.findAll().stream().map(obj -> new MedicoDTO(obj)).
                collect(Collectors.toList());
    }
    public Medico findbyId(Long id){
        Optional<Medico> obj = medicoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Medico não encontrado! Id: "+id));
    }

    public Medico create(MedicoDTO dto){
        dto.setId(null);
        Medico obj = new Medico(dto);
        return medicoRepo.save(obj);
    }

    public Medico update(Long id, MedicoDTO objDto){
        objDto.setId(id);
        Medico oldObj = findbyId(id);
        oldObj = new Medico(objDto);
        return medicoRepo.save(oldObj);
    }

    public void delete(Long id){
        Medico obj = findbyId(id);
        medicoRepo.deleteById(id);
    }
}
