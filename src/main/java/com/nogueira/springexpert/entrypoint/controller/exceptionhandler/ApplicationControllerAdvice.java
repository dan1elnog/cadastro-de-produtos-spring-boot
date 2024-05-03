package com.nogueira.springexpert.entrypoint.controller.exceptionhandler;

import com.nogueira.springexpert.util.exception.LoginJaCadastradoException;
import com.nogueira.springexpert.util.exception.RegraNegocioException;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {
   @ExceptionHandler({RegraNegocioException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ApiErrors handleRegraNegocioException(RegraNegocioException regraNegocioException) {
      return new ApiErrors(regraNegocioException.getMessage());
   }

   @ExceptionHandler({MethodArgumentNotValidException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
      List<String> errors = (List)methodArgumentNotValidException.getBindingResult().getAllErrors().stream().map((e) -> {
         return e.getDefaultMessage();
      }).collect(Collectors.toList());
      return new ApiErrors(errors);
   }

   @ExceptionHandler({LoginJaCadastradoException.class})
   @ResponseStatus(HttpStatus.BAD_REQUEST)
   public ApiErrors handleLoginJaCadastradoException(LoginJaCadastradoException loginJaCadastradoException) {
      return new ApiErrors(loginJaCadastradoException.getMessage());
   }
}
