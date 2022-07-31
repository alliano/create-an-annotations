package com.customvalidator.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ParserErrorsUtil {
   
   public static List<String> parse(Errors errors){

      List<String> messages = new ArrayList<String>();

      for (ObjectError error : errors.getAllErrors()) {

         messages.add(error.getDefaultMessage());
      }
      
      return messages;
   }
}
