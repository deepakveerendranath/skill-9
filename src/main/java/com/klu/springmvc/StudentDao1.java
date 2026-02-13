package com.klu.springmvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDao1 {

  @Autowired
  StudentRepo1 srepo;
  
  public Student insert(Student s) {
    return srepo.save(s);
  }
  public boolean update(Student s) {
    Student s1 = srepo.findById(s.getId()).get();
    if(s1 == null) {
      return false;
    }
    else {
      srepo.delete(s1);
      srepo.save(s);
      return true;
    }
  }
     
  public boolean delete(int sid) {
	  
    if(srepo.findById(sid) == null) {
      return false;
    }
    else {
      srepo.deleteById(sid);
      return true;
    }
  }
  
  public List<Student> findAll(){
    return srepo.findAll();
    
  }
  
}