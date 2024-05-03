package com.nogueira.springexpert.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Entity
@Table(name = "cliente")
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer id;

   @Column(name = "nome", length = 100)
   @NotEmpty(message = "{campo.nome.obrigatorio}")
   private String nome;

   @Column(name = "cpf",length = 11)
   @NotEmpty(message = "{campo.cpf.obrigatorio}")
   @CPF(message = "campo.cpf.invalido")
   private String cpf;

   @OneToMany(mappedBy = "cliente")
   @JsonIgnore
   private Set<Pedido> pedidos;

}
