package com.nogueira.springexpert.dataprovider.repository;

import com.nogueira.springexpert.core.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
   @Query("SELECT c from Cliente c LEFT JOIN FETCH c.pedidos WHERE c.id = :id")
   Cliente findClienteFetchPedidos(@Param("id") Integer id);
}
