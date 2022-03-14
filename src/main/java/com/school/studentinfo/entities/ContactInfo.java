package com.school.studentinfo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contract")
public class ContactInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contractId;

    private String emailAddress;
    private String phoneNumber;
    private String statusInfo;
    @JsonManagedReference
    @OneToOne(mappedBy = "studentContract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private StudentInfo studentInfo;
    @JsonManagedReference
    @OneToOne(mappedBy = "teacherContract", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Teacher teacherInfo;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    //@JsonBackReference
    public StudentInfo getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfo studentInfo) {
        this.studentInfo = studentInfo;
    }

    public Teacher getTeacherInfo() {
        return teacherInfo;
    }

    public void setTeacherInfo(Teacher teacherInfo) {
        this.teacherInfo = teacherInfo;
    }
}
