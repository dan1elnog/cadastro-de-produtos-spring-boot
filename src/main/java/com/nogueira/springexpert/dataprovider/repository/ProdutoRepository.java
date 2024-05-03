package com.nogueira.springexpert.dataprovider.repository;

import com.nogueira.springexpert.core.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
