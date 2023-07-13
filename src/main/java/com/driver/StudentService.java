package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void addTeacher(Teacher teacher) {
        studentRepository.addTeacher(teacher);
    }

    public void adStudentTeacherPair(String student, String teacher) {
        studentRepository.adStudentTeacherPair(student,teacher);
    }

    public Student getStudent(String name) {
        return studentRepository.getStudent(name);
    }

    public Teacher getTeacherByName(String name) {
        return studentRepository.getTeacherByName(name);

    }

    public List<String> getAllStudentsByTeacherName(String teacher) {
        return studentRepository.getAllStudentsByTeacherName(teacher);
    }

    public List<String> getAllStudents() {
        return studentRepository.getAllStudents();
    }

    public void deleteTeacherByName(String teacher) {
        studentRepository.deleteTeacherByName(teacher);
    }

    public void deleteAllTeachers() {
        studentRepository.deleteAllTeachers();
    }
}
