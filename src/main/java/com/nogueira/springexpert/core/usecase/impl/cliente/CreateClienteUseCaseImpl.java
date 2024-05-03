package com.nogueira.springexpert.core.usecase.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.CreateCliente;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.core.usecase.cliente.CreateClienteUseCase;

public class CreateClienteUseCaseImpl implements CreateClienteUseCase {
   private final CreateCliente createCliente;

   public CreateClienteUseCaseImpl(CreateCliente createCliente) {
      this.createCliente = createCliente;
   }

   public void create(Cliente cliente) {
      this.createCliente.create(cliente);
   }
}
