package com.nogueira.springexpert.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "item_pedido")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ItemPedido {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @ManyToOne
   @JoinColumn(name = "pedido_id")
   @JsonBackReference
   private Pedido pedido;

   @ManyToOne
   @JoinColumn(name = "produto_id")
   private Produto produto;

   @Column(name = "quantidade")
   private Integer quantidade;

}
