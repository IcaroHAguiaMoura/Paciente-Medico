package com.curso.resources;

import com.curso.domains.Paciente;
import com.curso.domains.dtos.PacienteDTO;
import com.curso.services.PacienteService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/paciente")
public class PacienteResource {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<PacienteDTO>> findAll(){
        return ResponseEntity.ok().body(pacienteService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> findById(@PathVariable Long id){
        Paciente obj = this.pacienteService.findbyId(id);
        return ResponseEntity.ok().body(new PacienteDTO(obj));
    }

    @PostMapping
    public ResponseEntity<PacienteDTO> create(@Valid @RequestBody PacienteDTO dto){
        Paciente paciente = pacienteService.create(dto);
        //Cria a URI para o recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(paciente.getId()).toUri();
        //Retorna a resposta com o status 201 Created e o local do recurso criado
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> update(@PathVariable Long id, @Valid @RequestBody PacienteDTO objDto){
        Paciente Obj = pacienteService.update(id,objDto);
        return ResponseEntity.ok().body(new PacienteDTO(Obj));

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<PacienteDTO> delete(@PathVariable Long id){
        pacienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

