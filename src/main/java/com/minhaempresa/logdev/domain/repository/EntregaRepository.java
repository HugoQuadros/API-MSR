package com.minhaempresa.logdev.domain.repository;

import com.minhaempresa.logdev.domain.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {



}
