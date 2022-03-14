package com.school.studentinfo.service;

import com.school.studentinfo.entities.ContactInfo;
import com.school.studentinfo.entities.Course;
import com.school.studentinfo.entities.StudentInfo;
import com.school.studentinfo.entities.Teacher;

import java.util.List;

public interface StudentService {

    void saveCourse(Course courseInfo);
    List<StudentInfo> getStudentList();
    List<Teacher> getTeacherList();
    void removeCourse(int id);
    List<Course> getCourse();
    String updateContact(ContactInfo contactInfo);

}
