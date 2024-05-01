package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
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
        TypedQuery<Doctors> theQuery = entityManager.createQuery("FROM Doctors Order By surname", Doctors.class);    // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)

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
    @Transactional
    public void save(Doctors theDoctors) {
        //entityManager.merge(theDoctors);          HAZIR METHOD

        String sql = "INSERT INTO doctors (doctor_id, name, surname, professiont, working_hospital) " +
                "VALUES (:id, :name, :surname, :professiont, :workingHospital)";

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
    public void update(Doctors theDoctors) {
        /*String sql = "UPDATE doctors " +
                "SET name = :name, " +
                "surname = :surname, " +
                "professiont = :professiont, " +
                "working_hospital = :workingHospital " +
                "WHERE doctor_id = :id";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("name", theDoctor.getName());
        query.setParameter("surname", theDoctor.getSurname());
        query.setParameter("profession", theDoctor.getProfessiont());
        query.setParameter("workingHospital", theDoctor.getWorkingHospital());


        query.executeUpdate();*/
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        /*// retrieve the student                    HAZIR METHOD
        Doctors theDoctors = entityManager.find(Doctors.class, theId);
        // delete the student
        entityManager.remove(theDoctors);*/


        // create query
        String sql = "DELETE FROM Doctors where doctor_id = :theId";   // FROM'dan sonra tam olarak javadaki sınıfın adı olmalı (case sensitive)
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("theId", theId);
        query.executeUpdate();
    }
}






