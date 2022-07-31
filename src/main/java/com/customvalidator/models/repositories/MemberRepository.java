package com.customvalidator.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.customvalidator.models.entities.Member;


public @Repository interface MemberRepository extends JpaRepository<Member,Long>{
   
   public boolean existsMemberBynumber(String number);

   public boolean existsMemberByEmail(String email);
}
