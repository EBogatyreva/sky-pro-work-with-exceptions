package pro.sky.skyproworkwithexceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.service.EmployeeGetByOficce;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeByOfficeServiceImpl implements EmployeeGetByOficce {
    private Integer index = 0;
    private Map<Integer, Employee> employees;

    public EmployeeByOfficeServiceImpl() {
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

    public Map<Integer, Employee> getEmployeeList() {
        return employees;
    }


    @Override
    public Collection<Employee> findEmployeeByOffice(Integer office) throws NotFoundException {
        return employees.values().stream().filter(employee -> employee.getOffice() == office).collect(Collectors.toList());

    }
}
