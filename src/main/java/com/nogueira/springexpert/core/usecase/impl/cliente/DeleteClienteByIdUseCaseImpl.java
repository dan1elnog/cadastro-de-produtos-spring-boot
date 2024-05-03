package com.nogueira.springexpert.core.usecase.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.DeleteClienteById;
import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.core.usecase.cliente.DeleteClienteByIdUseCase;

public class DeleteClienteByIdUseCaseImpl implements DeleteClienteByIdUseCase {
   private final DeleteClienteById deleteClienteById;
   private final FindClienteById findClienteById;

   public DeleteClienteByIdUseCaseImpl(DeleteClienteById deleteClienteById, FindClienteById findClienteById) {
      this.deleteClienteById = deleteClienteById;
      this.findClienteById = findClienteById;
   }

   public void delete(Integer id) {
      Cliente cliente = this.findClienteById.find(id);
      this.deleteClienteById.delete(cliente.getId());
   }
}
