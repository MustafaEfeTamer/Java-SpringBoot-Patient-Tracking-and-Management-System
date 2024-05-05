package com.luv2code.springboot.thymeleafdemo.entity;

import jakarta.persistence.*;

    @Entity
    @Table(name="patients")
    public class  Patients{
        // define fields
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="patient_id")
        private int id;
        @Column(name="name")
        private String name;

        @Column(name="surname")
        private String surname;

        @Column(name="birth_date")
        private String birthDate;

        @Column(name = "gender")
        private String gender;

        @Column(name = "phone_number")
        private String phoneNumber;

        @Column(name = "address")
        private String address;

        @Column(name = "patient_username")
        private String patientUsername;

        @Column(name = "patient_password")
        private String patientPassword;

        // define constructors
        public Patients(){

        }

        public Patients(String name, String surname, String birthDate, String gender, String phoneNumber, String address, String patientUsername, String patientPassword) {
            this.name = name;
            this.surname = surname;
            this.birthDate = birthDate;
            this.gender = gender;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.patientUsername = patientUsername;
            this.patientPassword = patientPassword;
        }


        // define getter/setter
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

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPatientUsername() {
            return patientUsername;
        }

        public void setPatientUsername(String patientUsername) {
            this.patientUsername = patientUsername;
        }

        public String getPatientPassword() {
            return patientPassword;
        }

        public void setPatientPassword(String patientPassword) {
            this.patientPassword = patientPassword;
        }

        // define toString method
        @Override
        public String toString() {
            return "Patients{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", birthDate='" + birthDate + '\'' +
                    ", gender='" + gender + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", address='" + address + '\'' +
                    ", patientUsername='" + patientUsername + '\'' +
                    ", patientPassword='" + patientPassword + '\'' +
                    '}';
        }
    }




