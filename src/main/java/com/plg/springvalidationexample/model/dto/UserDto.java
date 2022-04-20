package com.plg.springvalidationexample.model.dto;

import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserDto {
  @NotNull(message = "Le non d'utilisateur est requis")
  private String name;
  @Email(message = "Email non valide")
  private String email;
  @Pattern(regexp = "^\\d{10}$", message = "numero de telepphone invalide")
  private String password;
  @Max(1)
  private String gender;
  @Min(18)
  @Max(65)
  private int age;
  @NotBlank
  private String nationality;
}
