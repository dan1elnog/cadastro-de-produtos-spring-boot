package com.nogueira.springexpert.core.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.nogueira.springexpert.core.enums.StatusPedido;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Data
@Table(name = "pedido")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @ManyToOne
   @JoinColumn(name = "cliente_id")
   private Cliente cliente;

   @Column(name = "data_pedido")
   private LocalDate dataPedido;

   @Column(name = "total", scale = 2,precision = 20)
   private BigDecimal total;

   @OneToMany(mappedBy = "pedido")
   @JsonManagedReference
   private List<ItemPedido> itemPedidos;

   @Column(name = "status_pedido")
   @Enumerated(EnumType.STRING)
   private StatusPedido statusPedido;

}
