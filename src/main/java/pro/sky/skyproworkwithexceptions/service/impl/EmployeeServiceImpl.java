package pro.sky.skyproworkwithexceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyproworkwithexceptions.exception.BadRequest;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.service.EmployeeService;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Integer index = 0;
    private Map<Integer, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        employees.put(getIndex(), new Employee("Иван", "Иванов", 1, 30_000));
        employees.put(getIndex(), new Employee("Владимир", "Соколов", 1, 50_000));
        employees.put(getIndex(), new Employee("Анна", "Миронова", 2, 70_000));
        employees.put(getIndex(), new Employee("Сергей", "Васильев", 3, 100_000));
    }

    private Integer getIndex() {
        Integer result = index;
        index = index + 1;
        return result;
    }

    public List<Employee> getEmployeeList() {
        return (List<Employee>) employees;
    }

    @Override
    public String addNewEmployee(String firstName, String lastName, int office, int salary) throws BadRequest {
        Employee employee1 = new Employee(firstName, lastName, office, salary);

        if (employees.containsValue(employee1)) {
            throw new BadRequest();
        } else
            employees.put(getIndex(), employee1);
        return employee1 + " " + "Сотрудник добавлен";
    }

    @Override
    public String delEmployee(String firstName, String lastName, int office, int salary) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName, office, salary);
        if (!employees.containsValue(employee1)) {
            throw new NotFoundException();
        } else
            employees.values().remove(employee1);
        return "Cотрудник " + employee1 + " удалён";
    }

    @Override
    public String findEmployee(String firstName, String lastName, int office, int salary) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName, office, salary);

        if (!employees.containsValue(employee1)) {
            throw new NotFoundException();
        } else
            return "Сотрудник найден " + employee1;
    }
       }