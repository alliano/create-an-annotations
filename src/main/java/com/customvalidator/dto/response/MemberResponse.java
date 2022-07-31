package com.customvalidator.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//ini untuk memparsing data yang ingin di tampilkan ke client nya
public @Setter @Getter @NoArgsConstructor class MemberResponse {
   
   private long id;

   private String name;

   private String email;

   private String number;
}
