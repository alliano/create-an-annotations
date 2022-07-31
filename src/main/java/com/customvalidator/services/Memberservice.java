package com.customvalidator.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customvalidator.models.entities.Member;
import com.customvalidator.models.repositories.MemberRepository;

public @Service class Memberservice {
   
   private @Autowired MemberRepository memberRepository;

   public Member create(Member member){
      return memberRepository.save(member);
   }

   public List<Member> getAll(){
      return memberRepository.findAll();
   }
}
