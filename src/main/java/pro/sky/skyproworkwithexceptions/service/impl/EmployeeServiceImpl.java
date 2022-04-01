package pro.sky.skyproworkwithexceptions.service.impl;

import org.springframework.stereotype.Service;
import pro.sky.skyproworkwithexceptions.exception.BadRequest;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.exception.OverFlowException;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee2;

    List<Employee> employees = new ArrayList<>(List.of(
            new Employee(
                    "Иван", "Иванов"),
            new Employee(
                    "Владимир", "Соколов"),
            new Employee(
                    "Анна", "Миронова"),
            new Employee(
                    "Сергей", "Васильев")));

    @Override
    public String getDescriptionEmployee(int number) {
        return "{" + employees.get(number).getFirstName() + " " + employees.get(number).getLastName() + " }";
    }

    public List<Employee> getEmployeeList() {
        return employees;
    }

    @Override
    public String addNewEmployee(String firstName, String lastName) throws OverFlowException, BadRequest {
        Employee employee1 = new Employee(firstName, lastName);
        String a = null;

        for (Employee employee : employees) {
            if (employee != null) {
                if (employee.equals(employee1) == true) {//if find employee
                    a = null;
                    break;
                } else a = "Можно добавить";
            }
        }

        if (a == null) {
            throw new BadRequest();        //400 Bad Request.
        }

        employees.add(employee1);
        a = "Cотрудник добавлен";

        return a;
    }

    @Override
    public String delEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a = null;
        for (int i = 0; i < employees.size(); i++) {
            if ((employees.get(i) != null) && (employees.get(i).equals(employee1))) {
                a = "Cотрудник " + employees.get(i).toString() + " удалён";
                //почему конструкция a = "Cотрудник " + employee1.getfirstName + " удалён"; не работает?
                //а только через employees[i].toString()?
                employees.get(i).setFirstName(null);
                employees.get(i).setLastName(null);
            }
        }
        if (a == null) {
            throw new NotFoundException();
        }// 404 Not Found.
        return a;
    }

    @Override
    public String findEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a1 = null;
        for (int i = 0; i < employees.size(); i++) {
            if ((employees.get(i) != null) && (employees.get(i).equals(employee1)))
                a1 = employees.get(i).toString();
        }
        if (a1 == null) {
            throw new NotFoundException();
        }// 404 Not Found.
        return a1;
    }

    @Override
    public boolean equals(Object obj) {
        boolean b = false;
        Employee employee = (Employee) obj;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(employee))
                b = true;
        }
        return b;
    }

}