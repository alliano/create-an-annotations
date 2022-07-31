package com.customvalidator.dto.response;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public @Setter @Getter @AllArgsConstructor class ResponseHttp<T> {
   
   private boolean status;

   private List<String> message = new ArrayList<String>();

   private T payload;

   public ResponseHttp(){}
}
