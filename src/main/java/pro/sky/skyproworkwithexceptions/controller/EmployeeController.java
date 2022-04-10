package pro.sky.skyproworkwithexceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.BadRequest;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.exception.OverFlowException;
import pro.sky.skyproworkwithexceptions.service.impl.EmployeeServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

/*
    @GetMapping("/max-salary")
    public String maxSalary(@RequestParam(required = true) int department) {
        return "" + employeeService.maxSalaryByOffice(department);
    }

    @GetMapping("/min-salary")
    public String minSalary(@RequestParam(required = true) int department) {
        return "" + employeeService.minSalaryByOffice(department);
    }
*/
    @GetMapping("/all")
    public String allEmployees() {
        return "Всен сотрудники " + employeeService.getDescriptionEmployee();
    }


    @GetMapping("/get")
    public Map<Integer, Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

    @GetMapping("/all")
    public String findEmployeeByOffice(@RequestParam(required = true) Integer office) {
        return employeeService.findEmployeeByOffice(office).toString();
    }

    @GetMapping("/add")
    public String add(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) int office, @RequestParam(required = true) int salary) throws OverFlowException, BadRequest {
        return "Добавить нового сотрудника: " + employeeService.addNewEmployee(firstName, lastName, office, salary);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) int office, @RequestParam(required = true) int salary) throws NotFoundException {
        return "Удалить сотрудника: " + employeeService.delEmployee(firstName, lastName, office, salary);
    }

    @GetMapping("/find")
    public String find(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName, @RequestParam(required = true) int office, @RequestParam(required = true) int salary) throws NotFoundException {
        return "Найти сотрудника: " + employeeService.findEmployee(firstName, lastName, office, salary);
    }
}