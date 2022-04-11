package pro.sky.skyproworkwithexceptions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.service.impl.EmployeeByOfficeServiceImpl;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class EmployeeGetByOfficeController {

    private final EmployeeByOfficeServiceImpl employeeService;

    public EmployeeGetByOfficeController(EmployeeByOfficeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public Collection<Employee> findEmployeeByOffice(@RequestParam(required = true) Integer office) throws NotFoundException {
        return employeeService.findEmployeeByOffice(office);
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
/*    @GetMapping("/all")
    public String allEmployees() {
        return "Все сотрудники " + employeeService.getDescriptionEmployee();
    }*/

}
