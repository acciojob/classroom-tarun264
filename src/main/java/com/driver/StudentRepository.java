package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String,Teacher> teacherDb= new HashMap<>();
    HashMap<String,Student> studentDb= new HashMap<>();

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
        List<String> studentList= new ArrayList<>();
        if(teacherStudentPairDB.containsKey(teacher)) {
            studentList = teacherStudentPairDB.get(teacher);
        }
        if(!studentList.contains(student)){
            studentList.add(student);
        }
        teacherStudentPairDB.put(teacher,studentList);

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

        List<String> getAllStudent= new ArrayList<>(studentDb.keySet());

        return getAllStudent;
    }


    public void deleteTeacherByName(String teacher) {
        teacherDb.remove(teacher);

        for(String findTeacher: teacherStudentPairDB.keySet()){
            List<String> studentList= new ArrayList<>();
            if(findTeacher.equals(teacher)){
                studentList=teacherStudentPairDB.get(findTeacher);
                    for(String st: studentList){
                        studentDb.remove(st);
                    }
                }
            }
            teacherStudentPairDB.remove(teacher);
        }

    public void deleteAllTeachers() {
        for(String findTeacher: teacherStudentPairDB.keySet()){
            List<String> studentList= teacherStudentPairDB.get(findTeacher);
                for(String st: studentList){
                    studentDb.remove(st);
                }
            }
        teacherDb.clear();
        teacherStudentPairDB.clear();

    }
}




