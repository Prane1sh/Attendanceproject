package com.iamneo.security.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamneo.security.entity.Contact;


@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
   
}