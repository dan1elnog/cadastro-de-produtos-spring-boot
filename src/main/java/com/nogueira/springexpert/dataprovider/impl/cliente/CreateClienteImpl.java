package com.nogueira.springexpert.dataprovider.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.CreateCliente;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.dataprovider.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateClienteImpl implements CreateCliente {
   @Autowired
   ClienteRepository clienteRepository;

   public void create(Cliente cliente) {
      this.clienteRepository.save(cliente);
   }
}
