package com.customvalidator.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.customvalidator.models.repositories.MemberRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumberUniqueConstraintValidator implements ConstraintValidator<NumberUniqueConstraint,String> {

   private @Autowired MemberRepository memberRepository;

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {

      return !memberRepository.existsMemberBynumber(value);
   }

}
