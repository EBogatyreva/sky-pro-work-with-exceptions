package pro.sky.skyproworkwithexceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyproworkwithexceptions.exception.BadRequest;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.service.EmployeeService;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Integer index = 0;
    private Map<Integer, Employee> employees;

    private EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        employees.put(getIndex(), new Employee("Иван", "Иванов"));
        employees.put(getIndex(), new Employee("Владимир", "Соколов"));
        employees.put(getIndex(), new Employee("Анна", "Миронова"));
        employees.put(getIndex(), new Employee("Сергей", "Васильев"));
    }

    private Integer getIndex() {
        Integer result = index;
        index = index + 1;
        return result;
    }

    public Map<Integer, Employee> getEmployeeList() {
        return employees;
    }

    @Override
    public String getDescriptionEmployee(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        if (employees.containsValue(employee1)) {
            return "Сотрудник "+employee1;
        } else return "Не найден";
    }

    @Override
    public String addNewEmployee(String firstName, String lastName) throws BadRequest {
        Employee employee1 = new Employee(firstName, lastName);
        if (employees.containsValue(employee1)) {//if find employee
            throw new BadRequest();
        } else
            employees.put(getIndex(), employee1);
        return employee1 + " " + "Сотрудник добавлен";
    }

    @Override
    public String delEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        if (employees.containsValue(employee1)) {
            employees.values().remove(employee1);
            return "Cотрудник " + employee1 + " удалён";
        } else if (!employees.containsValue(employee1))
            return "Не найден";
        throw new NotFoundException();
        // 404 Not Found.
    }

    @Override//
    public String findEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);

        if (employees.containsValue(employee1)) {
            return "Сотрудник найден " + employee1;
        } else if (!employees.containsValue(employee1))
            return "Не найден";
        throw new NotFoundException();
    }
}