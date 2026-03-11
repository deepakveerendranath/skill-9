package com.klu.springmvc;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepo1 extends JpaRepository<Student, Integer> {
  public Student findByName(String name);
  public Student findByNameAndCgpa(String name, double cgpa);
  @Modifying
  @Transactional
  @Query("update Student s set s.cgpa = :cgpa where s.name = :name")
  public int updateCgpaByName(String name, double cgpa);
}