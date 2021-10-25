package com.minhaempresa.logdev.domain.service;

import com.minhaempresa.logdev.domain.exception.NegocioException;
import com.minhaempresa.logdev.domain.model.Cliente;
import com.minhaempresa.logdev.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if(emailEmUso){
            throw new NegocioException("Ja existe um cliente cadastrado com este email");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id){
        clienteRepository.deleteById(id);
    }
}