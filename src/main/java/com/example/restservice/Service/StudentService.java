package com.example.restservice.Service;

import com.example.restservice.Dao.ClassDao;
import com.example.restservice.Dao.StudentDao;
import com.example.restservice.Model.SchoolClass;
import com.example.restservice.Model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDao studentDao;

    public Student GetStudent(String class_name, String student_name) {
        try {
            Student student = studentDao.GetStudent(class_name, student_name);
            return student;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }

    public List<Student> ListStudent(String class_name) {
        try {
            return studentDao.ListStudents(class_name);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }

    public Student AddStudent(String class_name, Student student) {
        try {
            return studentDao.AddStudent(class_name, student);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Already exist");
        }
    }

    public Student UpdateStudent(String class_name, String student_name, Student student) {
        try {
            Student s = studentDao.UpdateStudent(class_name, student_name, student);
            return s;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }

    public void DeleteStudent(String class_name, String student_name) {
        try {
            studentDao.DeleteStudent(class_name, student_name);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }
}
