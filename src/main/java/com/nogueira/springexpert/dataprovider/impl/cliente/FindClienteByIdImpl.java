package com.nogueira.springexpert.dataprovider.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.FindClienteById;
import com.nogueira.springexpert.core.domain.Cliente;
import com.nogueira.springexpert.dataprovider.repository.ClienteRepository;
import com.nogueira.springexpert.util.exception.RegraNegocioException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FindClienteByIdImpl implements FindClienteById {
   @Autowired
   private ClienteRepository clienteRepository;

   public Cliente find(Integer id) {
      return (Cliente)this.clienteRepository.findById(id).orElseThrow(() -> {
         return new RegraNegocioException("CLIENTE NAO ENCONTRADO");
      });
   }
}
