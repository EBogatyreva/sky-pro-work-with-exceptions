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

    Map<Integer, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
        employees.put(0, new Employee("Иван", "Иванов"));
        employees.put(1, new Employee("Владимир", "Соколов"));
        employees.put(2, new Employee("Анна", "Миронова"));
        employees.put(3, new Employee("Сергей", "Васильев"));
    }

    public Map<Integer, Employee> getEmployeeList() {
        return employees;
    }

    @Override
    public String getDescriptionEmployee(Integer index) {
        if (employees.containsKey(index))
            return "{" + employees.get(index).toString() + " }";
        return "Не найден";
    }

    @Override
    public String addNewEmployee(Integer index, String firstName, String lastName) throws BadRequest {
        Employee employee1 = new Employee(firstName, lastName);
        String a = null;

        if (employees.containsKey(index) == true) {//if find employee
            a = null;
        } else {
            employees.put(index, employee1);
            a = "Сотрудник добавлен";
        }

        if (a == null) {
            throw new BadRequest();
            //400 Bad Request.
        }

        return employee1 + " " + a;
    }

    @Override
    public String delEmployee(Integer index, String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a = null;

        if ((employees.containsKey(index)) && (employees.containsValue(employee1))) {
            a = "Cотрудник " + employees.get(index).getFirstName() + " " + employees.get(index).getLastName() + " удалён";
            employees.remove(index);
        }

        if (a == null) {
            throw new NotFoundException();
        }// 404 Not Found.
        return a;
    }

    @Override//
    public String findEmployee(Integer index, String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a1 = null;

        if ((employees.containsKey(index)) && (employees.containsValue(employee1))) {
            return employees.get(index).toString();
        }

        if (a1 == null) {
            throw new NotFoundException();
        }// 404 Not Found.
        return a1;
    }

    @Override
    public boolean equals(Object obj) {
        boolean isEquals = false;
        Employee employee = (Employee) obj;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee))
                isEquals = true;
        }
        return isEquals;
    }

}