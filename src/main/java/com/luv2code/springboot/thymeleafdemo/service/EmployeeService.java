package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
import java.util.List;

public interface EmployeeService {

    List<Doctors> findAll();

    Doctors findById(int theId);

    void save(Doctors theDoctors);

    void update(Doctors theDoctors);

    void deleteById(int theId);
}
