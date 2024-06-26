package com.terzocloud.employeez.controller;

import com.terzocloud.employeez.dto.*;
import com.terzocloud.employeez.entity.Department;
import com.terzocloud.employeez.entity.Employee;
import com.terzocloud.employeez.service.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class EmployeeRestController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/all")
    public List<EmployeeDto> findAllEmployees(){
        List<EmployeeDto> employees = employeeService.findAll();
        return employees;
    }


    @GetMapping("/employees/{employeeId}")
    public EmployeeDto findEmployeeById(@PathVariable Integer employeeId){
        EmployeeDto employee = employeeService.findById(employeeId);
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody RegisterDto registerDto){
        return employeeService.save(registerDto);
    }

    @PutMapping("/employees")
    public EmployeeDto updateEmployee(@RequestBody UpdateByEmployeeDto updateDto, HttpServletRequest request){
        return employeeService.update(updateDto,request);
    }

    @PutMapping("/employees/edit")
    public EmployeeDto editEmployee(@RequestBody UpdateEmployeeDto updateDto ){
        return employeeService.updateEmployee(updateDto);
    }
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable Integer employeeId){
        employeeService.delete(employeeId);
    }

    @GetMapping("/employees/dept/{employeeId}")
    public Department  findDepartment(@PathVariable Integer employeeId){
        return employeeService.findDepartment(employeeId);
    }
   
    @GetMapping("/employees/edit/{employeeId}")
    public UpdateEmployeeDto findEmployeeByIdForEdit(@PathVariable Integer employeeId){
        UpdateEmployeeDto updateEmployeeDto = employeeService.findByIdForEdit(employeeId);
        return updateEmployeeDto;
    }



    @GetMapping("/employees/count")
    public int findEmployeesCount(HttpServletRequest request){
        System.out.println("find Employees count method called");
        int count = employeeService.findEmployeesCount();
        System.out.println(count);
        return count;
    }

    //dashboard details
    @GetMapping("/dashboard")
    public DashboardDto getDashboardDetails(HttpServletRequest request){
        DashboardDto dashboardDto = employeeService.getDashboardDetails(request);
        return dashboardDto;
    }
    //managers
    @GetMapping("/managers")
    public List<EmployeeDto> getManagers(){
        List<EmployeeDto> managers = employeeService.findAllManagers();
        return managers;
    }


    //ProfileDto
    @GetMapping("/profileDto")
    public ProfileDto getProfileDto(HttpServletRequest request){
        ProfileDto profileDto = employeeService.getProfileDto(request);
        return profileDto;
    }

    @GetMapping("/employees/profileDetails")
    public EmployeeDto getProfileDetails(HttpServletRequest request){
        EmployeeDto employeeDto = employeeService.findEmployeeForUpdate(request);
        return employeeDto;
    }
}
