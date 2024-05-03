package com.nogueira.springexpert.core.usecase.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClientes;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.core.usecase.cliente.FindClientesUseCase;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class FindClientesUseCaseImpl implements FindClientesUseCase {
   private final FindClientes findClientes;

   public FindClientesUseCaseImpl(FindClientes findClientes) {
      this.findClientes = findClientes;
   }

   public Page<Cliente> find(Pageable pageable) {
      return this.findClientes.find(pageable);
   }
}
