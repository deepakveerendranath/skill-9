package com.klu.springmvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class StudentDao1 {

    @Autowired
    private StudentRepo1 srepo;

    public Student insert(Student s) {
        return srepo.save(s);
    }

    public boolean update(Student s) {
        if (!srepo.existsById(s.getId())) {
            return false;
        }
        srepo.save(s);
        return true;
    }

    public boolean delete(int sid) {
        if (!srepo.existsById(sid)) {
            return false;
        }
        srepo.deleteById(sid);
        return true;
    }

    public List<Student> findAll() {
        return srepo.findAll();
    }

    public Student findByName(String name) {
        return srepo.findByName(name);
    }

    public Student findByNameAndCgpa(String name, double cgpa) {
        return srepo.findByNameAndCgpa(name, cgpa);
    }

    public Page<Student> findPage(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit, Sort.by("name").descending());
        return srepo.findAll(pageable);
    }

    public String updateCgpaByName(String name, double cgpa) {
        if (srepo.findByName(name) == null) {
            return "Student Not Found";
        }
        int updated = srepo.updateCgpaByName(name, cgpa);
        return updated == 1 ? "Updated Successfully" : "Not Updated";
    }
}