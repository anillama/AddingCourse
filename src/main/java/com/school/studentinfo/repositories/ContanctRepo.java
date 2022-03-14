package com.school.studentinfo.repositories;

import com.school.studentinfo.entities.ContactInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContanctRepo extends JpaRepository<ContactInfo, Integer> {

    public ContactInfo findByEmailAddress(String email);
}
