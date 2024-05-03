package com.nogueira.springexpert.core.enums;

public enum UserRole {
   ADMIN("admin"),
   USER("user");

   private String typeRole;

   private UserRole(String typeRole) {
      this.typeRole = typeRole;
   }

   public String getTypeRole() {
      return this.typeRole;
   }

}
