package com.nsibandelh.exampractice;

public class Student {
    private String sClassOf;
    private int iStudentNo;
    private String sFirstName;
    private String sLastName;
    private int iAge;
    private String sGender;

    public Student(String sClassOf, int iStudentNo, String sFirstName, String sLastName, int iAge, String sGender) {
        this.sClassOf = sClassOf;
        this.iStudentNo = iStudentNo;
        this.sFirstName = sFirstName;
        this.sLastName = sLastName;
        this.iAge = iAge;
        this.sGender = sGender;
    }

    public String getsClassOf() {
        return sClassOf;
    }

    public void setsClassOf(String sClassOf) {
        this.sClassOf = sClassOf;
    }

    public int getiStudentNo() {
        return iStudentNo;
    }

    public void setiStudentNo(int iStudentNo) {
        this.iStudentNo = iStudentNo;
    }

    public String getsFirstName() {
        return sFirstName;
    }

    public void setsFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public int getiAge() {
        return iAge;
    }

    public void setiAge(int iAge) {
        this.iAge = iAge;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }
}
