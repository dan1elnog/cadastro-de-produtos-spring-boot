package com.nogueira.springexpert.entrypoint.controller.request;

import com.nogueira.springexpert.core.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CriarUsuarioRequest {
   private String login;
   private String password;
   private UserRole role;
}
