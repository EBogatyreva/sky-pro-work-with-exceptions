package pro.sky.skyproworkwithexceptions;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
    public String addNewEmployee(String firstName, String lastName) throws OverFlowException {
        Employee employee1 = new Employee(firstName, lastName);
        String a = " ";
        for (int i = 0; i < employees.length; i++) {
            if (state(employees) == true) {
                throw new OverFlowException();// 500 Internal Server Error массив переполнен
            } else if ((employees[i] == null)) {
                if (employees[i].equals(employee1)) {
                    throw new BadRequest();
                    //400 Bad Request.
                }
                employees[i].setFirstName(firstName);
                employees[i].setLastName(lastName);
                System.out.println("Добавлен новый сотрудник " + firstName + " " + lastName);
                a = "Добавлен новый сотрудник " + firstName + "" + lastName;
            }
        }
        return a;
    }

    @Override
    public String delEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a = "";
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].equals(employee1) == false) {
                throw new NotFoundException();// 404 Not Found.
            } else if (employees[i].equals(employee1) == true) {
                employees[i].setFirstName(null);
                employees[i].setLastName(null);
                System.out.println("Cотрудник " + firstName + " " + lastName + " удалён");
                a = "Cотрудник " + firstName + " " + lastName + " удалён";
            } else a = "что-то пошло не так";
        }
        return a;
    }

    @Override
    public String findEmployee(String firstName, String lastName) throws NotFoundException {
        Employee employee1 = new Employee(firstName, lastName);
        String a1 = "";
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i].getFirstName() != null) && (employees[i].getLastName() != null)) {
                if (employees[i].equals(employee1) == false) {
                    throw new NotFoundException();// 404 Not Found.
                } else if (employees[i].equals(employee1) == true) {
                    System.out.println("Cотрудник " + firstName + " " + lastName);
                    a1 = "Cотрудник " + firstName + " " + lastName;
                }
            }
        }
        return a1;
    }

    @Override
    public boolean equals(Employee employee) {
        boolean b = false;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getFirstName() == employee.getFirstName() && (employees[i].getLastName() == employee.getLastName()))
                b = true;
        }
        return b;
    }

    public static boolean state(Employee[] employee) {
        boolean state = false;//если переполнен

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null)
                state = true;
            else state = false;
        }
        return state;
    }

}
