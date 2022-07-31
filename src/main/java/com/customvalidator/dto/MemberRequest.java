package com.customvalidator.dto;

import com.customvalidator.validators.NumberUniqueConstraint;
import com.customvalidator.validators.PasswordEqualConstrain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@PasswordEqualConstrain(message = "retype password doesn't match with password !")
public @AllArgsConstructor @Setter @Getter  class MemberRequest {
   
   @NotEmpty(message = "name is required !")
   private String name;

   @Email(message = "email doesn't valid !")
   @NotEmpty(message = "email is required")
   private String email;

   @NotEmpty(message = "number can't be empty !")
   @Size(max = 12,message = "numbers must lenght 12 !")
   @NumberUniqueConstraint(message = "number already exist !")
   // @Pattern(regexp = "+62[0-9]*", message = "number must start with \'+62\'")
   private String number;

   @NotEmpty(message = "password id required !")
   private String password;

   @NotEmpty(message = "retype password is required !")
   private String retypePassword;
}
