package com.nogueira.springexpert.core.usecase.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.dataprovider.cliente.UpdateCliente;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.core.usecase.cliente.UpdateClienteUseCase;

public class UpdateClienteUseCaseImpl implements UpdateClienteUseCase {
   private final FindClienteById findClienteById;
   private final UpdateCliente updateClienteById;

   public UpdateClienteUseCaseImpl(FindClienteById findClienteById, UpdateCliente updateClienteById) {
      this.findClienteById = findClienteById;
      this.updateClienteById = updateClienteById;
   }

   public void update(Cliente clienteRequest) {
      Cliente cliente = this.findClienteById.find(clienteRequest.getId());
      cliente.setNome(clienteRequest.getNome());
      cliente.setPedidos(clienteRequest.getPedidos());
      this.updateClienteById.update(cliente);
   }
}
