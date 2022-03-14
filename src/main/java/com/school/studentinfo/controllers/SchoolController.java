package com.school.studentinfo.controllers;

import com.school.studentinfo.entities.ContactInfo;
import com.school.studentinfo.entities.Course;
import com.school.studentinfo.entities.StudentInfo;
import com.school.studentinfo.entities.Teacher;
import com.school.studentinfo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private StudentService studentService;

    @PostMapping(value = "/saveCourse")
    public ResponseEntity saveCourse(@RequestBody Course courseInfo) {
        studentService.saveCourse(courseInfo);
        return new ResponseEntity((HttpStatus.ACCEPTED));
    }

    @GetMapping("/getStudentList")
    public List<StudentInfo> studentList() {
        List<StudentInfo> getStudentList = studentService.getStudentList();
        if (getStudentList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return getStudentList;
    }

    @GetMapping("/getTeacherList")
    public List<Teacher> teacherList() {
        List<Teacher> getTeacherList = studentService.getTeacherList();
        if (getTeacherList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return getTeacherList;
    }

    @DeleteMapping("/removecourse/{id}")
    public String deleteContact(@PathVariable Integer id) {
        try {
            studentService.removeCourse(id);
        } catch (Exception ie) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "Success";
    }

    @GetMapping("/getCourse")
    public List<Course> getCourse() {
        List<Course> getCourse = studentService.getCourse();

        if (getCourse.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
        return getCourse;
    }

    @PutMapping("/updateContactInfo/{id}")
    public String updateContactInfo(@RequestBody ContactInfo contactInfo, @PathVariable Integer id) {
        contactInfo.setContractId(id);
        String message = studentService.updateContact(contactInfo);
        return message;
    }
}

