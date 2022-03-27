package pro.sky.skyproworkwithexceptions;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/hello")
    public String helloEmployee(int number) {
        return "Hello! "+ employeeService.getDescriptionEmployee(number);
    }

    @GetMapping("/add")

    public String add(String fisrstName, String lastName) throws OverFlowException {
        return "Добавить нового сотрудника: " + employeeService.addNewEmployee(fisrstName, lastName);
    }

    @GetMapping("/remove")
    public String remove(String fisrstName, String lastName) throws NotFoundException {
        return "Удалить сотрудника: " + employeeService.delEmployee(fisrstName, lastName);
    }

    @GetMapping("/find")
    public String find(String firstNane, String lastName) throws NotFoundException {
        return "Найти сотрудника: "+employeeService.findEmployee(firstNane, lastName);}
    }

