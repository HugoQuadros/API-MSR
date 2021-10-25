package com.minhaempresa.logdev.api.controller;

import com.minhaempresa.logdev.api.assembler.EntregaAssembler;
import com.minhaempresa.logdev.api.model.EntregaInputModel;
import com.minhaempresa.logdev.api.model.EntregaModel;
import com.minhaempresa.logdev.domain.model.Entrega;
import com.minhaempresa.logdev.domain.repository.EntregaRepository;
import com.minhaempresa.logdev.domain.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/entregas")
public class EntregaController {

    @Autowired
    private EntregaRepository entregaRepository;
    @Autowired
    private EntregaService entregaService;
    @Autowired
    private EntregaAssembler entregaAssembler;

    @GetMapping
    public List<EntregaModel> listar(){
        return entregaAssembler.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscarPorId(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaAssembler.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaInputModel entregaInput){
        Entrega novaEntrega = entregaAssembler.toEntity(entregaInput);
        Entrega entregaSolicitada = entregaService.solicitarEntrega(novaEntrega);
        return entregaAssembler.toModel(entregaSolicitada);
    }

}