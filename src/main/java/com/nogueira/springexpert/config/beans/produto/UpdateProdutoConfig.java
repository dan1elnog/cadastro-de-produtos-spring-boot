package com.nogueira.springexpert.config.beans.produto;

import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.dataprovider.produto.UpdateProduto;
import com.nogueira.springexpert.core.usecase.impl.produto.UpdateProdutoUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateProdutoConfig {

   @Bean
   public UpdateProdutoUseCaseImpl updateProdutoUseCase(FindProdutoById findProdutoById, UpdateProduto updateProduto) {
      return new UpdateProdutoUseCaseImpl(findProdutoById, updateProduto);
   }
}
