package com.nogueira.springexpert.config.beans.produto;

import com.nogueira.springexpert.core.dataprovider.produto.DeleteProdutoById;
import com.nogueira.springexpert.core.dataprovider.produto.FindProdutoById;
import com.nogueira.springexpert.core.usecase.impl.produto.DeleteProdutoByIdUseCaseimpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteProdutoByIdConfig {

   @Bean
   public DeleteProdutoByIdUseCaseimpl deleteProdutoByIdUseCaseimpl(FindProdutoById findProdutoById, DeleteProdutoById deleteProdutoById) {
      return new DeleteProdutoByIdUseCaseimpl(findProdutoById, deleteProdutoById);
   }
}
