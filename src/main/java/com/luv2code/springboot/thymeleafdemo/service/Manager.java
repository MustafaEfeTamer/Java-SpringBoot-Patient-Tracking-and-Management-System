package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Appointments;
import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
import com.luv2code.springboot.thymeleafdemo.entity.Patients;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
public class Manager implements EmployeeService {
    private EntityManager entityManager;

    @Autowired
    public Manager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Doctors> findAll() {
        // create query
        TypedQuery<Doctors> theQuery = entityManager.createQuery("FROM Doctors Order By name", Doctors.class);    // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Patients> findAll2() {
        // create query
        TypedQuery<Patients> theQuery = entityManager.createQuery("FROM Patients Order By name", Patients.class);    // Order by dan sonraki ifade field olan ifade sql deki değil

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Appointments> findAllAppointmentsDoctors() {
        // create query
        TypedQuery<Appointments> theQuery = entityManager.createQuery("FROM Appointments Order By doctorId", Appointments.class);    // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)

        // return query results
        return theQuery.getResultList();
    }


    @Override
    public List<Appointments> findAllAppointmentsPatients() {
        // create query
        TypedQuery<Appointments> theQuery = entityManager.createQuery("FROM Appointments Order By patientId", Appointments.class);     // Order by dan sonraki ifade field olan ifade sql deki değil

        // return query results
        return theQuery.getResultList();
    }


    @Override
    public Doctors findById(int theId) {
        return entityManager.find(Doctors.class, theId);     //HAZIR METHOD
        /* TypedQuery<Doctors> theQuery = entityManager.createQuery("FROM Doctors where doctor_id = :theId", Doctors.class);
         theQuery.setParameter("theId", theId);

         // return query result
        return theQuery.getSingleResult();*/
    }

    @Override
    public Patients findById2(int theId) {
        return entityManager.find(Patients.class, theId);     //HAZIR METHOD
        /* TypedQuery<Doctors> theQuery = entityManager.createQuery("FROM Doctors where doctor_id = :theId", Doctors.class);
         theQuery.setParameter("theId", theId);

         // return query result
        return theQuery.getSingleResult();*/
    }


    @Override
    @Transactional
    public void save(Doctors theDoctors) {
        //entityManager.merge(theDoctors);          HAZIR METHOD

        String sql = "INSERT INTO doctors (doctor_id, name, surname, professiont, working_hospital, doctor_username, doctor_password) " +
                "VALUES (:id, :name, :surname, :professiont, :workingHospital, :doctorUsername, :doctorPassword)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", theDoctors.getId());
        query.setParameter("name", theDoctors.getName());
        query.setParameter("surname", theDoctors.getSurname());
        query.setParameter("professiont", theDoctors.getProfessiont());
        query.setParameter("workingHospital", theDoctors.getWorkingHospital());
        query.setParameter("doctorUsername", theDoctors.getDoctorUsername());
        query.setParameter("doctorPassword", theDoctors.getDoctorPassword());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void save2(Patients thePatients) {
        String sql = "INSERT INTO patients (patient_id, name, surname, birth_date, gender, phone_number, address, patient_username, patient_password) " +
                "VALUES (:id, :name, :surname, :birthDate, :gender, :phoneNumber, :address, :patientUsername, :patientPassword)";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", thePatients.getId());
        query.setParameter("name", thePatients.getName());
        query.setParameter("surname", thePatients.getSurname());
        query.setParameter("birthDate", thePatients.getBirthDate());
        query.setParameter("gender", thePatients.getGender());
        query.setParameter("phoneNumber", thePatients.getPhoneNumber());
        query.setParameter("address", thePatients.getAddress());
        query.setParameter("patientUsername", thePatients.getPatientUsername());
        query.setParameter("patientPassword", thePatients.getPatientPassword());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void update(Doctors theDoctors) {
        String sql = "UPDATE doctors " +
                "SET name = :name, " +
                "surname = :surname, " +
                "professiont = :professiont, " +
                "working_hospital = :workingHospital " +
                "WHERE doctor_id = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", theDoctors.getId());
        query.setParameter("name", theDoctors.getName());
        query.setParameter("surname", theDoctors.getSurname());
        query.setParameter("professiont", theDoctors.getProfessiont());
        query.setParameter("workingHospital", theDoctors.getWorkingHospital());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void update2(Patients thePatients) {
        String sql = "UPDATE patients " +
                "SET name = :name, " +
                "surname = :surname, " +
                "birth_date = :birthDate, " +
                "gender = :gender, " +
                "phone_number = :phoneNumber, " +
                "address = :address " +
                "WHERE patient_id = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("id", thePatients.getId());
        query.setParameter("name", thePatients.getName());
        query.setParameter("surname", thePatients.getSurname());
        query.setParameter("birthDate", thePatients.getBirthDate());
        query.setParameter("gender", thePatients.getGender());
        query.setParameter("phoneNumber", thePatients.getPhoneNumber());
        query.setParameter("address", thePatients.getAddress());

        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteById(int theId, String person) {
        /*// retrieve the student                    HAZIR METHOD
        Doctors theDoctors = entityManager.find(Doctors.class, theId);
        // delete the student
        entityManager.remove(theDoctors);*/

        if(person == "doctor"){
            // create query
            String sql2 = "DELETE FROM appointments where doctor_id = :theId";   // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
            Query query2 = entityManager.createNativeQuery(sql2);
            query2.setParameter("theId", theId);
            query2.executeUpdate();

            // create query
            String sql = "DELETE FROM doctors where doctor_id = :theId";   // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("theId", theId);
            query.executeUpdate();
        }else if(person == "patient"){
            String sql1 = "DELETE FROM report_results WHERE report_id IN (SELECT report_id FROM reports WHERE patient_id = :id)";
            Query query1 = entityManager.createNativeQuery(sql1);
            query1.setParameter("id",theId);
            query1.executeUpdate();

            // create query
            String sql2 = "DELETE FROM reports where patient_id = :theId";   // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
            Query query2 = entityManager.createNativeQuery(sql2);
            query2.setParameter("theId", theId);
            query2.executeUpdate();

            // create query
            String sql3 = "DELETE FROM appointments where patient_id = :theId";   // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
            Query query3 = entityManager.createNativeQuery(sql3);
            query3.setParameter("theId", theId);
            query3.executeUpdate();


            // create query
            String sql = "DELETE FROM patients where patient_id = :theId";   // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
            Query query = entityManager.createNativeQuery(sql);
            query.setParameter("theId", theId);
            query.executeUpdate();
        }
    }

    public boolean authenticateUser(String username, String password) {
        boolean x;
        List<Doctors> doctor = findByUsernameAndPassword(username, password);

        if(doctor.isEmpty()){
            x = false;
        }else{
            x = true;
        }
        //return doctor != null;
        return x;
    }

    public boolean authenticateUser2(String username, String password) {
        boolean x;
        List<Patients> patient = findByUsernameAndPassword2(username, password);

        if(patient.isEmpty()){
            x = false;
        }else{
            x = true;
        }
        return x;
        //return patient != null;
    }


    @Override
    public List<Doctors> findByUsernameAndPassword(String username, String password) {
        // create query
        TypedQuery<Doctors> theQuery = entityManager.createQuery("FROM Doctors WHERE doctorUsername = :username AND doctorPassword = :password ORDER BY name", Doctors.class);    // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
        theQuery.setParameter("username", username);
        theQuery.setParameter("password", password);

        // return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Patients> findByUsernameAndPassword2(String username, String password) {
        // create query
        TypedQuery<Patients> theQuery = entityManager.createQuery("FROM Patients WHERE patientUsername = :username AND patientPassword = :password ORDER BY name", Patients.class);    // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
        theQuery.setParameter("username", username);
        theQuery.setParameter("password", password);

        // return query results
        return theQuery.getResultList();
    }
}
