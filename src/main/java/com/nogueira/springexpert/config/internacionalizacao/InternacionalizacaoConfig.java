package com.nogueira.springexpert.config.internacionalizacao;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class InternacionalizacaoConfig {

   @Bean
   public MessageSource messageSource() {
      ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
      messageSource.setBasename("classpath:messages");
      messageSource.setDefaultLocale(Locale.getDefault());
      messageSource.setDefaultEncoding("ISO-8859-1");
      return messageSource;
   }

   @Bean
   public LocalValidatorFactoryBean localValidatorFactoryBean() {
      LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
      localValidatorFactoryBean.setValidationMessageSource(this.messageSource());
      return localValidatorFactoryBean;
   }
}
