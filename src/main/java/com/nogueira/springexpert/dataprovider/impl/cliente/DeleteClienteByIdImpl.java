package com.nogueira.springexpert.dataprovider.impl.cliente;

import com.nogueira.springexpert.core.dataprovider.cliente.DeleteClienteById;
import com.nogueira.springexpert.dataprovider.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteClienteByIdImpl implements DeleteClienteById {
   @Autowired
   ClienteRepository clienteRepository;

   public void delete(Integer id) {
      this.clienteRepository.deleteById(id);
   }
}
