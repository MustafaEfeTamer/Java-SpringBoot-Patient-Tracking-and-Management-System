package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Appointments;
import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
import com.luv2code.springboot.thymeleafdemo.entity.Patients;

import java.util.List;

public interface EmployeeService {

    List<Doctors> findAll();
    List<Patients> findAll2();
    List<Appointments> findAllAppointmentsDoctors();
    List<Appointments> findAllAppointmentsPatients();
    Doctors findById(int theId);
    Patients findById2(int theId);
    List<Doctors> findByUsernameAndPassword(String username, String password);
    List<Patients> findByUsernameAndPassword2(String username, String password);

    boolean authenticateUser(String username, String password);
    boolean authenticateUser2(String username, String password);


    void save(Doctors theDoctors);
    void save2(Patients thePatients);
    void update(Doctors theDoctors);
    void update2(Patients thePatients);

    void deleteById(int theId, String person);
}
