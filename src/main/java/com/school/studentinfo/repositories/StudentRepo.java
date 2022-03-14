package com.school.studentinfo.repositories;

import com.school.studentinfo.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentInfo, Integer> {
}
