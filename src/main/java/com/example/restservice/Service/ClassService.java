package com.example.restservice.Service;

import com.example.restservice.Dao.ClassDao;
import com.example.restservice.Model.SchoolClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClassService {
    @Autowired
    ClassDao classDao;

    public SchoolClass GetClass(String name) {
        try {
            SchoolClass c = classDao.GetClass(name);
            return c;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }

    public List<SchoolClass> ListClass() {
        return classDao.ListClass();
    }

    public SchoolClass AddClass(SchoolClass new_class) {
        try {
            SchoolClass c = classDao.AddClass(new_class);
            return c;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Already exist");
        }
    }

    public SchoolClass UpdateClass(String name, SchoolClass updated_class) {
        try {
            SchoolClass c = classDao.UpdateClass(name, updated_class);
            return c;
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT);
        }
    }

    public void DeleteClass(String name) {
        try {
            classDao.DeleteClass(name);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not Found");
        }
    }
}
