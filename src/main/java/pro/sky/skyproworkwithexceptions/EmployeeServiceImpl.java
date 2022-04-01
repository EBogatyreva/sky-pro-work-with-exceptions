package pro.sky.skyproworkwithexceptions;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee2;

    public Employee[] employees = {
            new Employee(
                    "Иван", "Иванов"),
            new Employee(
                    "Владимир", "Соколов"),
            new Employee(
                    "Анна", "Миронова"),
            new Employee(
                    "Сергей", "Васильев"),
            null,
            null,
            null,
            null,
            null,
            null};

    @Override
    public String getDescriptionEmployee(int number) {
        return "{" + employees[number].getFirstName() + " " + employees[number].getLastName() + " }";
    }

    @Override
    public String addNewEmployee(String firstName, String lastName) throws OverFlowException, BadRequest {
        Employee employee1 = new Employee(firstName, lastName);
        String a = null;

        if (state(employees) == true) {
            throw new OverFlowException();
        }

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

        if (state(employees) == false) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    employees[i] = employee1;
                    a = "Cотрудник " + employees[i].toString() + " добавлен";
                    break;
                }
            }
        }

        return a;
    }

    @Override
    public String delEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a = null;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].equals(employee1))) {
                a = "Cотрудник " + employees[i].toString() + " удалён";
                //почему конструкция a = "Cотрудник " + employee1.getfirstName + " удалён"; не работает?
                //а только через employees[i].toString()?
                employees[i].setFirstName(null);
                employees[i].setLastName(null);
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
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].equals(employee1)))
                a1 = employees[i].toString();
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
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employee))
                b = true;
        }
        return b;
    }

    public static boolean state(Employee[] employee) {//если переполнен
        boolean state = false;

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                state = true;
            } else state = false;
        }
        return state;
    }

}
