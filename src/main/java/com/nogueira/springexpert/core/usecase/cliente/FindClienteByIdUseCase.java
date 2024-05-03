package com.nogueira.springexpert.core.usecase.cliente;

import com.nogueira.springexpert.core.domain.Cliente;

public interface FindClienteByIdUseCase {
   Cliente find(Integer id);
}
