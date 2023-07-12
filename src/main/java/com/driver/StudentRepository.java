package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Teacher> teacherDb= new HashMap<>();
    HashMap<String,Student> studentDb= new HashMap<>();
    HashMap<String,String> teacherStudentDb= new HashMap<>();
    HashMap<String, List<String>> teacherStudentPairDB= new HashMap<>();

    public void addStudent(Student student) {
        String studentName= student.getName();
        studentDb.put(studentName,student);
    }

    public void addTeacher(Teacher teacher) {
        String teacherName= teacher.getName();
        teacherDb.put(teacherName,teacher);
    }

    public void adStudentTeacherPair(String student, String teacher) {
        if(teacherDb.containsKey(teacher) && studentDb.containsKey(student)){
            teacherStudentDb.put(teacher,student);
        }
        List<String> studentsList= new ArrayList<>();
        if(!studentsList.contains(student)) {
            studentsList.add(student);
            teacherStudentPairDB.put(teacher, studentsList);
        }
    }

    public Student getStudent(String name) {
        if(!studentDb.containsKey(name)){
            return null;
        }
        return studentDb.get(name);
    }


    public Teacher getTeacherByName(String name) {
        if(!teacherDb.containsKey(name)){
            return null;
        }
        return teacherDb.get(name);
    }

    public List<String> getAllStudentsByTeacherName(String teacher) {
        if(!teacherStudentPairDB.containsKey(teacher)){
            return null;
        }
        List<String> getAllStudentsNameByTeacher= new ArrayList<>(teacherStudentPairDB.get(teacher));
        return getAllStudentsNameByTeacher;
    }


    public List<String> getAllStudents() {
        if(teacherStudentPairDB.isEmpty()) return null;

        List<String> getAllStudent= new ArrayList<>();

        for(String teachers:teacherStudentPairDB.keySet()){
            for(String students: teacherStudentPairDB.get(teachers)){
                getAllStudent.add(students);
            }
        }
        return getAllStudent;
    }


    public void deleteTeacherByName(String teacher) {
        if(teacherDb.containsKey(teacher)) {
            teacherDb.remove(teacher);
        }

            if(teacherStudentDb.containsKey(teacher)) {
                teacherStudentDb.remove(teacher);
            }
                for(String teachers: teacherStudentPairDB.keySet()){
                    if(teachers.equals(teacher)){
                        teacherStudentPairDB.remove(teachers);
                    }
                }
            }

    public void deleteAllTeachers() {
        teacherDb.clear();
        teacherStudentPairDB.clear();
        teacherStudentDb.clear();
    }
}




