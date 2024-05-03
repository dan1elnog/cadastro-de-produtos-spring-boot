package com.nogueira.springexpert.core.usecase.cliente;

import com.nogueira.springexpert.core.domain.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindClientesUseCase {
   Page<Cliente> find(Pageable pageable);
}
