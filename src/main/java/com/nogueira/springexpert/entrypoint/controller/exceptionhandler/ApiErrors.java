package com.nogueira.springexpert.entrypoint.controller.exceptionhandler;

import java.util.Arrays;
import java.util.List;

public class ApiErrors {
   private final List<String> errors;

   public ApiErrors(String mensagemErro) {
      this.errors = Arrays.asList(mensagemErro);
   }

   public ApiErrors(List<String> errors) {
      this.errors = errors;
   }

   public List<String> getErrors() {
      return this.errors;
   }
}
