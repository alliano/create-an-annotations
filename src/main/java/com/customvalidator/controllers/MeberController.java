package com.customvalidator.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customvalidator.dto.MemberRequest;
import com.customvalidator.dto.response.MemberResponse;
import com.customvalidator.dto.response.ResponseHttp;
import com.customvalidator.models.entities.Member;
import com.customvalidator.services.Memberservice;
import com.customvalidator.utilities.ParserErrorsUtil;

import eye2web.modelmapper.ModelMapper;
import jakarta.validation.Valid;

public @RestController @RequestMapping(path = "/") class MeberController {
   
   private @Autowired Memberservice memberservice;

   private @Autowired ModelMapper modelMapper;

   @PostMapping(path = "/create")
   public ResponseEntity<ResponseHttp<?>> create(@Valid @RequestBody MemberRequest memberRequest, Errors errors ){
      
      ResponseHttp<MemberResponse> responseHttp = new ResponseHttp<MemberResponse>();

      if (errors.hasErrors()){

         responseHttp.setMessage(ParserErrorsUtil.parse(errors));

         responseHttp.setStatus(false);

         responseHttp.setPayload(null);

         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseHttp);
      }
      else{

         try {
            
            Member member = modelMapper.map(memberRequest, Member.class);
            
            Member result = memberservice.create(member);
      
            responseHttp.setStatus(true);
      
            responseHttp.getMessage().add("success save !");
      
            responseHttp.setPayload(modelMapper.map(result, MemberResponse.class));
      
            return ResponseEntity.status(HttpStatus.OK).body(responseHttp);

         } catch (Exception e) {

            responseHttp.getMessage().add(e.getMessage());

            responseHttp.setStatus(false);

            responseHttp.setPayload(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseHttp);
            
         }
         
      }

   }

   @GetMapping(path = "")
   public ResponseEntity<ResponseHttp<List<?>>> getAllMember(){

      ResponseHttp<List<?>> responseHttp = new ResponseHttp<List<?>>();

      List<MemberResponse> results = new ArrayList<>();

      memberservice.getAll().forEach((member) -> {
         results.add(modelMapper.map(member, MemberResponse.class));
      });

      responseHttp.setStatus(true);

      responseHttp.getMessage().add("success to get all member !");

      responseHttp.setPayload(results);

      return ResponseEntity.status(HttpStatus.OK).body(responseHttp);

      };

}
