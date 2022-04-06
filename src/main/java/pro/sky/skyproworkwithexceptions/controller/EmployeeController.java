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


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String helloEmployee(int number) {
        return "Hello! " + employeeService.getDescriptionEmployee(number);
    }

    @GetMapping("/add")
    public String add(@RequestParam(required = true) int index, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName) throws OverFlowException, BadRequest {
        return "Добавить нового сотрудника: " + employeeService.addNewEmployee(index, firstName, lastName);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(required = true) int index, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName) throws NotFoundException {
        return "Удалить сотрудника: " + employeeService.delEmployee(index, firstName, lastName);
    }

    @GetMapping("/find")
    public String find(@RequestParam(required = true) int index, @RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName) throws NotFoundException {
        return "Найти сотрудника: " + employeeService.findEmployee(index, firstName, lastName);
    }

    @GetMapping("/get")
    public Map<Integer, Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
    }

}