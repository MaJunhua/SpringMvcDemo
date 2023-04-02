package com.example.restservice.Dao;

import com.example.restservice.Model.SchoolClass;
import com.example.restservice.Model.Student;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class StudentDao {
    private Map<String, Map<String, Student>> class_students;

    StudentDao() {
        this.class_students = new HashMap();
    }

    public Student GetStudent(String class_name, String student_name) {
        if (!class_students.containsKey(class_name) || !class_students.get(class_name).containsKey(student_name)) {
            throw new IllegalArgumentException("not found");
        }
        return class_students.get(class_name).get(student_name);
    }

    public List<Student> ListStudents(String class_name) {
        if (!class_students.containsKey(class_name)) {
            throw new IllegalArgumentException("not found");
        }
        return class_students.get(class_name).values().stream().toList();
    }

    public Student AddStudent(String class_name, Student student) {
        if (!class_students.containsKey(class_name)) {
            class_students.put(class_name, new HashMap<>());
        }
        if (class_students.get(class_name).containsKey(student)) {
            throw new IllegalArgumentException("already exist");
        }
        class_students.get(class_name).put(student.name(), student);
        return student;
    }

    public Student UpdateStudent(String class_name, String student_name, Student student) {
        if (!class_students.containsKey(class_name)) {
            throw new IllegalArgumentException("class not exists");
        }
        if (!class_students.get(class_name).containsKey(student_name)) {
            throw new IllegalArgumentException("student not exists");
        }
        class_students.get(class_name).replace(student_name, student);
        return student;
    }

    public void DeleteStudent(String class_name, String student_name) {
        if (!class_students.containsKey(class_name) || !class_students.get(class_name).containsKey(student_name)) {
            throw new IllegalArgumentException("not exists");
        }
        class_students.get(class_name).remove(student_name);
    }
}
