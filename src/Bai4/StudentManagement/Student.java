package Bai4.StudentManagement;

import java.sql.Date;

public class Student {
    private int studentID;
    private float studentGPA;
    private String studentName, studentGender,studentPhone;
    private Date studentDateOfBirth;

    public Student(int studentID, String studentPhone, float studentGPA, String studentName, String studentGender, Date studentDateOfBirth) {
        this.studentID = studentID;
        this.studentPhone = studentPhone;
        this.studentGPA = studentGPA;
        this.studentName = studentName;
        this.studentGender = studentGender;
        this.studentDateOfBirth = studentDateOfBirth;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public float getStudentGPA() {
        return studentGPA;
    }

    public void setStudentGPA(int studentGPA) {
        this.studentGPA = studentGPA;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    public Date getStudentDateOfBirth() {
        return studentDateOfBirth;
    }

    public void setStudentDateOfBirth(Date studentDateOfBirth) {
        this.studentDateOfBirth = studentDateOfBirth;
    }
}
