package com.nogueira.springexpert.config.beans.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.usecase.impl.produto.FindProdutoByIdUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProdutoByIdConfig {

   @Bean
   public FindProdutoByIdUseCaseImpl findProdutoByIdUseCase(FindProdutoById findProdutoById) {
      return new FindProdutoByIdUseCaseImpl(findProdutoById);
   }
}
