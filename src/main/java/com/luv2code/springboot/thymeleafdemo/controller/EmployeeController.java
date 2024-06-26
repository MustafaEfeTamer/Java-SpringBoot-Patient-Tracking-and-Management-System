package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Appointments;
import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
import com.luv2code.springboot.thymeleafdemo.entity.Patients;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model theModel){
        // get the doctors from db
        List<Doctors> theDoctors = employeeService.findAll();
        List<Patients> thePatients = employeeService.findAll2();

        // add to the spring model
        theModel.addAttribute("doctors", theDoctors);
        theModel.addAttribute("patients", thePatients);

        return "employees/list-employees";
    }

    @GetMapping("/list2")
    public String listDoctors(Model theModel){
        // get the doctor from db

        // add to the spring model

        return "employees/list-doctors";
    }

    @GetMapping("/list3")
    public String listPatients(Model theModel){
        // get the patient from db

        // add to the spring model

        return "employees/list-patients";
    }

    @GetMapping("/gate")
    public String gateOfUsers() {
        return "employees/gate-users";
    }

    @GetMapping("/entryForm")
    public String entryForm() {
        return "employees/entryForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (username.equals("manager") && password.equals("manager123")) {       // for manager panel
            return "redirect:/employees/list";
        } else if (employeeService.authenticateUser(username, password)) {       // for doctor panel
            return "redirect:/employees/list2";
        } else if (employeeService.authenticateUser2(username, password)) {      // for patient panel
            return "redirect:/employees/list3";
        } else {
            // Hatalı giriş durumunda bir mesaj gösterebilirsiniz
            return "redirect:/login?error";
        }
    }

    @GetMapping("seeDoctorsAppointments")
    public String seeDoctorsAppointments(Model theModel){
        // get the doctor's appointments from db
        List<Appointments> theAppointments = employeeService.findAllAppointmentsDoctors();
        // add to the spring model
        theModel.addAttribute("appointmentsDoctors", theAppointments);

        return "employees/list-appointmentsDoctors";
    }

    @GetMapping("seePatientsAppointments")
    public String seePatientsAppointments(Model theModel){
        // get the patient's appointments from db
        List<Appointments> theAppointments = employeeService.findAllAppointmentsPatients();
        // add to the spring model
        theModel.addAttribute("appointmentsPatients", theAppointments);

        return "employees/list-appointmentsPatients";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create model attribute to bind form data
        Doctors theDoctors = new Doctors();
        theModel.addAttribute("doctors", theDoctors);

        return "employees/addEmployee-form";
    }

    @GetMapping("/showFormForAdd2")
    public String showFormForAdd2(Model theModel){
        // create model attribute to bind form data
        Patients thePatients = new Patients();
        theModel.addAttribute("patients", thePatients);

        return "employees/form-addPatients";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("doctorId") int theId, Model theModel){
        // get the doctor from the service
        Doctors theDoctors = employeeService.findById(theId);

        // set doctor in the model to prepopulate the form
        theModel.addAttribute("doctors", theDoctors);

        // send over to our form
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate2")
    public String showFormForUpdate2(@RequestParam("patientId") int theId, Model theModel){
        // get the doctor from the service
        Patients thePatients = employeeService.findById2(theId);

        // set doctor in the model to prepopulate the form
        theModel.addAttribute("patients", thePatients);

        // send over to our form
        return "employees/form-patients";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("doctorId") int theId){
        // delete the doctor
        employeeService.deleteById(theId, "doctor");

        // redirect to the /employees/list
        return "redirect:/employees/list";
    }

    @GetMapping("/delete2")         // html dosyasında bu anotasyona bakarak bu methodu çalıştırcak method adına göre değil
    public String delete2(@RequestParam("patientId") int theId2){
        // delete the patient
        employeeService.deleteById(theId2, "patient");

        // redirect to the /employees/list
        return "redirect:/employees/list";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("doctors") Doctors theDoctors){
        // save the doctor
        employeeService.save(theDoctors);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/save2")
    public String saveEmployee2(@ModelAttribute("patients") Patients thePatients){
        // save the doctor
        employeeService.save2(thePatients);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("doctors") Doctors theDoctors){
        // update the doctor
        employeeService.update(theDoctors);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }

    @PostMapping("/update2")
    public String updateEmployee(@ModelAttribute("patients") Patients thePatients){
        // update the doctor
        employeeService.update2(thePatients);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}
