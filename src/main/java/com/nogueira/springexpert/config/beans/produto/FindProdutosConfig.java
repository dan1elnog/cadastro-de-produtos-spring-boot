package com.nogueira.springexpert.config.beans.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutos;
import com.nogueira.springexpert.core.usecase.impl.produto.FindProdutosUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindProdutosConfig {

   @Bean
   public FindProdutosUseCaseImpl findProdutosUseCase(FindProdutos findProdutos) {
      return new FindProdutosUseCaseImpl(findProdutos);
   }
}
