package com.nogueira.springexpert.entrypoint.controller.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest {
   @NotEmpty
   private String login;
   @NotEmpty
   private String password;
}
