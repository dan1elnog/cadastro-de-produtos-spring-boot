package com.nogueira.springexpert.core.domain;

import com.nogueira.springexpert.core.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Table(name = "usuarios")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements UserDetails {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column(name = "login")
   @NotEmpty
   private String login;

   @Column(name = "password")
   @NotEmpty
   private String password;

   @Column(name = "role")
   @NotNull
   @Enumerated(EnumType.STRING)
   private UserRole role;

   public Collection<? extends GrantedAuthority> getAuthorities() {
      return this.role.equals(UserRole.ADMIN) ?
              List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER")) :
              List.of(new SimpleGrantedAuthority("ROLE_USER"));
   }

   public String getUsername() {
      return this.login;
   }

   public boolean isAccountNonExpired() {
      return true;
   }

   public boolean isAccountNonLocked() {
      return true;
   }

   public boolean isCredentialsNonExpired() {
      return true;
   }

   public boolean isEnabled() {
      return true;
   }

}
