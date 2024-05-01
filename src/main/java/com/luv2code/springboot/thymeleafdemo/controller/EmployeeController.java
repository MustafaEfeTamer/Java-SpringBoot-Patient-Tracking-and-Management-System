package com.luv2code.springboot.thymeleafdemo.controller;

import com.luv2code.springboot.thymeleafdemo.entity.Doctors;
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

        // add to the spring model
        theModel.addAttribute("doctors", theDoctors);

        System.out.println("efelikk");
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel){
        // create model attribute to bind form data
        Doctors theDoctors = new Doctors();
        theModel.addAttribute("doctors", theDoctors);

        return "employees/employee-form";
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

    @GetMapping("/delete")
    public String delete(@RequestParam("doctorId") int theId){
        // delete the doctor
        employeeService.deleteById(theId);

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

    @PostMapping("/update")
    public String updateEmployee(@ModelAttribute("doctors") Doctors theDoctors){
        // update the doctor
        employeeService.update(theDoctors);

        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/list";
    }
}
