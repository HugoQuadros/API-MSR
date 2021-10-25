package com.minhaempresa.logdev.domain.service;

import com.minhaempresa.logdev.domain.model.Cliente;
import com.minhaempresa.logdev.domain.model.Entrega;
import com.minhaempresa.logdev.domain.model.StatusEntrega;
import com.minhaempresa.logdev.domain.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
public class EntregaService {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitarEntrega(Entrega entrega){
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);
    }
}
