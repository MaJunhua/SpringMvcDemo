package com.example.restservice.Dao;
import com.example.restservice.Model.SchoolClass;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ClassDao {

    private Map<String, SchoolClass> classes;

    ClassDao() {
        this.classes = new HashMap();
    }

    public SchoolClass GetClass(String name) {
        if (!classes.containsKey(name)) {
            throw new IllegalArgumentException("not found");
        }
        return new SchoolClass("Class A", 1);
    }

    public List<SchoolClass> ListClass() {
        return classes.values().stream().toList();
    }

    public SchoolClass AddClass(SchoolClass new_class) {
        if (classes.containsKey(new_class.name())) {
            throw new IllegalArgumentException("already exist");
        }
        classes.put(new_class.name(), new_class);
        return new_class;
    }

    public SchoolClass UpdateClass(String name, SchoolClass updated_class) {
        if (!classes.containsKey(name)) {
            throw new IllegalArgumentException("not found");
        }
        classes.replace(name, updated_class);
        return updated_class;
    }

    public void DeleteClass(String name) {
        if (!classes.containsKey(name)) {
            throw new IllegalArgumentException("not found");
        }
        classes.remove(name);
    }


}
