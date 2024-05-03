package com.nogueira.springexpert.core.dataprovider.cliente;

import com.nogueira.springexpert.core.domain.Cliente;

public interface FindClienteById {
   Cliente find(Integer id);
}
