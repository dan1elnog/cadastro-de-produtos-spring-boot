package com.nogueira.springexpert.dataprovider.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClientes;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.dataprovider.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindClientesImpl implements FindClientes {
   @Autowired
   private ClienteRepository clienteRepository;

   public Page<Cliente> find(Pageable pageable) {
      return this.clienteRepository.findAll(pageable);
   }
}
