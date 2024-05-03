package com.nogueira.springexpert.core.dataprovider.produto;

import com.nogueira.springexpert.core.domain.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FindProdutos {
   Page<Produto> find(Pageable pageable);
}
