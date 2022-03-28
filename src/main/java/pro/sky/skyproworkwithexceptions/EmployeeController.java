package pro.sky.skyproworkwithexceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String add(@RequestParam(required = true) String firstName, @RequestParam(required = true) String lastName) throws BadRequest {
        return "Добавить нового сотрудника: " + employeeService.addNewEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public String remove(@RequestParam(required = true) String fisrstName, @RequestParam(required = true) String lastName) throws NotFoundException {
        return "Удалить сотрудника: " + employeeService.delEmployee(fisrstName, lastName);
    }

    @GetMapping("/find")
    public String find(@RequestParam(required = true) String firstNane, @RequestParam(required = true) String lastName) throws NotFoundException {
        return "Найти сотрудника: " + employeeService.findEmployee(firstNane, lastName);
    }
}

