package com.nogueira.springexpert.dataprovider.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.UpdateCliente;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.dataprovider.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateClienteImpl implements UpdateCliente {
   @Autowired
   private ClienteRepository clienteRepository;

   public void update(Cliente cliente) {
      this.clienteRepository.save(cliente);
   }
}
