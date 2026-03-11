package com.klu.springmvc;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentDao{

  StudentRepo srepo = new StudentRepo();
  
  public boolean insert(Student s) {
    return srepo.sl.add(s);
  }
  public boolean update(Student s) {
     for(Student cs : srepo.sl) {
       if(cs.getId() == s.getId()) {
         srepo.sl.remove(cs);
         return insert(s);
        //srepo.sl.add(s);
       }
     }
     return false;
  }
     
  public boolean delete(int sid) {
    for(Student cs : srepo.sl) {
      if(cs.getId() == sid) {
        return srepo.sl.remove(cs);
      }
    }
    return false;
  }
  public List<Student> findAll(){
    return srepo.sl;
  }
    
  
  
}