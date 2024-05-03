package com.nogueira.springexpert.core.dataprovider.cliente;

import com.nogueira.springexpert.core.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindClientes {
   Page<Cliente> find(Pageable pageable);
}
