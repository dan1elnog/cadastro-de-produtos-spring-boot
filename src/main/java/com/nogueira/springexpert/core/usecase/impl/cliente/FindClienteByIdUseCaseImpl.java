package com.nogueira.springexpert.core.usecase.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.core.usecase.cliente.FindClienteByIdUseCase;

public class FindClienteByIdUseCaseImpl implements FindClienteByIdUseCase {
   private final FindClienteById findClienteById;

   public FindClienteByIdUseCaseImpl(FindClienteById findClienteById) {
      this.findClienteById = findClienteById;
   }

   public Cliente find(Integer id) {
      return this.findClienteById.find(id);
   }
}
