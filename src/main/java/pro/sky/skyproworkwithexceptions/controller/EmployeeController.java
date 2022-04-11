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

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get")
    public Map<Integer, Employee> getEmployeeList() {
        return employeeService.getEmployeeList();
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