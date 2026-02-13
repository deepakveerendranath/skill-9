package com.klu.springmvc;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "s58_table")
public class Student {
	@Id
  int id;
  String name;
  double cgpa;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getCgpa() {
    return cgpa;
  }
  public void setCgpa(double cgpa) {
    this.cgpa = cgpa;
  }
  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]";
  }
}