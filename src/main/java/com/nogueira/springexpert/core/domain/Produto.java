package com.nogueira.springexpert.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Table(name = "produto")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(name = "descricao")
   @NotEmpty(message = "{campo.descricao.obrigatorio}")
   private String descricao;

   @Column(name = "preco_unitario")
   @NotNull(message = "{campo.preco.obrigatorio}")
   private BigDecimal preco;

}
