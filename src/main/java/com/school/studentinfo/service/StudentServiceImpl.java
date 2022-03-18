package com.school.studentinfo.service;

import com.school.studentinfo.entities.ContactInfo;
import com.school.studentinfo.entities.Course;
import com.school.studentinfo.entities.StudentInfo;
import com.school.studentinfo.entities.Teacher;
import com.school.studentinfo.repositories.ContanctRepo;
import com.school.studentinfo.repositories.CourseRepo;
import com.school.studentinfo.repositories.StudentRepo;
import com.school.studentinfo.repositories.TeacherRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private TeacherRepo teacherRepo;

    @Autowired
    private ContanctRepo contanctRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public void saveCourse(Course courseInfo) {
        courseRepo.save(courseInfo);
    }

    @Override
    public List<StudentInfo> getStudentList() {
        List<StudentInfo> getStudentList = studentRepo.findAll();
        return getStudentList;
    }

    @Override
    public List<Teacher> getTeacherList() {
        List<Teacher> getTeacherList = teacherRepo.findAll();

        return getTeacherList;
    }

    @Override
    public void removeCourse(int id) {
        try {
            courseRepo.deleteById(id);
        } catch (Exception ie) {
            throw ie;
        }
    }

    @Override
    public List<Course> getCourse() {
        return courseRepo.findAll();
    }

    @Override
    public String updateContact(ContactInfo contactInfo) {
        int id = contactInfo.getContractId();
        Optional<ContactInfo> getContact = contanctRepo.findById(id);
        if(getContact.isPresent()){
            BeanUtils.copyProperties(contactInfo, getContact.get());
            contanctRepo.save(getContact.get());
            return "ContactInfo Update Successful";
        } else return "No Entity Found";

    }
}
