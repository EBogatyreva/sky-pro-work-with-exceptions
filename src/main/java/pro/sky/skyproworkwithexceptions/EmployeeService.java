package pro.sky.skyproworkwithexceptions;

import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class EmployeeService implements EmployeeServiceInterface {
    private Employee employee1 = new Employee();

    public Employee[] employee = {
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
        return "{" + employee[number].getFirstName() + " " + employee[number].getLastName() + " }";
    }

    @Override
    public String addNewEmployee(String firstName, String lastName) throws OverFlowException {
        String a = " ";
        for (int i = 0; i < employee.length; i++) {
            if (state(employee) == true) {
                throw new OverFlowException();// 500 Internal Server Error массив переполнен
            } else if ((employee[i].getFirstName() == null) && (employee[i].getLastName() == null)) {
                if (employee[i].getFirstName() == firstName && (employee[i].getLastName() == lastName)) {
                    //400 Bad Request.
                }
                employee[i].setFirstName(firstName);
                employee[i].setLastName(lastName);
                System.out.println("Добавлен новый сотрудник " + firstName + " " + lastName);
                a = "Добавлен новый сотрудник " + firstName + "" + lastName;
            }
        }
        return a;
    }

    @Override
    public String delEmployee(String firstName, String lastName) throws NotFoundException {
        String a = "";
        for (int i = 0; i < employee.length; i++) {
            if ((employee[i].getFirstName() != firstName) && (employee[i].getLastName() != lastName)) {
                throw new NotFoundException();// 404 Not Found.
            } else if ((employee[i].getFirstName() == firstName) && (employee[i].getLastName() == lastName)) {
                employee[i].setFirstName(null);
                employee[i].setLastName(null);
                System.out.println("Cотрудник " + firstName + " " + lastName + " удалён");
                a = "Cотрудник " + firstName + " " + lastName + " удалён";
            } else a = "что-то пошло не так";
        }
        return a;
    }

    @Override
    public String findEmployee(String firstName, String lastName) throws NotFoundException {
        String a1 = "";
        for (int i = 0; i < employee.length; i++) {
            if ((employee[i].getFirstName() != null) && (employee[i].getLastName() != null)) {
                if ((employee[i].getFirstName() != firstName) && (employee[i].getLastName() != lastName)) {
                    throw new NotFoundException();// 404 Not Found.
                } else if ((employee[i].getFirstName() == firstName) && (employee[i].getLastName() == lastName)) {
                    System.out.println("Cотрудник " + firstName + " " + lastName);
                    a1 = "Cотрудник " + firstName + " " + lastName;
                }
            }
        }
        return a1;
    }

    public boolean equals(String firstName, String lastName) {
        boolean b = false;
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].getFirstName() == firstName && (employee[i].getLastName() == lastName))
                b = true;
        }
        return b;
    }

    public void printAllEmployee() {
        for (int i = 0; i < employee.length; i++) {
            if (employee != null) {
                System.out.println(employee[i].getFirstName());
            }
        }
    }

    public static boolean state(Employee[] employee) {
        boolean state = true;//если переполнен

        for (int i = 0; i < employee.length; i++) {
            if (employee[i] != null) {
                state = true;
            } else state = false;
        }
        return state;
    }

}
