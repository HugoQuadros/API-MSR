package com.minhaempresa.logdev.api.model;

import com.minhaempresa.logdev.api.model.input.ClienteIdInput;
import com.minhaempresa.logdev.api.model.input.DestinatarioInput;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EntregaInputModel {

    @Valid
    @NotNull
    private ClienteIdInput cliente;

    @Valid
    @NotNull
    private DestinatarioInput destinatario;

    @NotNull
    private BigDecimal taxa;

}
