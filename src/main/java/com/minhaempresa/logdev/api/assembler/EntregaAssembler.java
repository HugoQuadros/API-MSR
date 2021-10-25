package com.minhaempresa.logdev.api.assembler;

import com.minhaempresa.logdev.api.model.EntregaInputModel;
import com.minhaempresa.logdev.api.model.EntregaModel;
import com.minhaempresa.logdev.domain.model.Entrega;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaAssembler(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EntregaModel toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInputModel entregaInput){
        return modelMapper.map(entregaInput, Entrega.class);
    }

}