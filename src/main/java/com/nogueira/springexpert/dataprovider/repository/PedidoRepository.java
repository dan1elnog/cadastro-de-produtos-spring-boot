package com.nogueira.springexpert.dataprovider.repository;

import com.nogueira.springexpert.core.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
