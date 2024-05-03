package com.nogueira.springexpert.config.beans.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutosByIdIn;
import com.nogueira.springexpert.core.usecase.impl.produto.FindProdutosByIdInUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProdutosByIdConfig {

   @Bean
   public FindProdutosByIdInUseCaseImpl findProdutosByIdInUseCase(FindProdutosByIdIn findProdutosByIdIn) {
      return new FindProdutosByIdInUseCaseImpl(findProdutosByIdIn);
   }
}
