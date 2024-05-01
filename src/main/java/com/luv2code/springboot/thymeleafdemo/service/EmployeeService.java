package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
import com.luv2code.springboot.thymeleafdemo.entity.Patients;

import java.util.List;

public interface EmployeeService {

    List<Doctors> findAll();

    List<Patients> findAll2();

    Doctors findById(int theId);

    void save(Doctors theDoctors);
    void save2(Patients thePatients);
    void update(Doctors theDoctors);

    void deleteById(int theId, String person);
}
