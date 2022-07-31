package com.customvalidator.validators;

import com.customvalidator.dto.MemberRequest;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * kelas ini harus meng implement interface Constrainvalidator<> dan generic inerface dari implement class nya
 * pertama kita isikan interface annotasi yang kita buat sebelumnnya (PasswordEqualConstrain.java) dan
 * parameter ke 2 dalah object yang mau di proses dalam study kasus ini saya ingin mengecek apakah properi
 * password dan retypePassword sama
 */

public class PasswordEqualConstrainValidator implements ConstraintValidator<PasswordEqualConstrain,Object> {

   @Override
   public boolean isValid(Object object, ConstraintValidatorContext context) {
      MemberRequest memberRequest = (MemberRequest) object;
      return memberRequest.getPassword().equals(memberRequest.getRetypePassword());
   }
   
}
