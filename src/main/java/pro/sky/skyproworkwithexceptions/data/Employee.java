package pro.sky.skyproworkwithexceptions.data;

import java.util.Objects;

public class Employee implements EmployeeInterface {
    private String firstName;
    private String LastName;
    private int office;
    private int salary;

    public Employee(String firstName, String lastName, int office, int salary) {
        this.firstName = firstName;
        this.LastName = lastName;
        this.office = office;
        this.salary = salary;
    }

    public Employee() {

    }

    @Override
    public int setOffice(int office) {
        return this.office = office;
    }

    @Override
    public int setSalary(int salary) {
        return this.salary = salary;
    }

    @Override
    public int getOffice() {
        return office;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return LastName;
    }


    @Override
    public String setFirstName(String firstName) {
        return this.firstName = firstName;
    }

    @Override
    public String setLastName(String lastName) {
        return this.LastName = lastName;
    }

    @Override
    public String toString() {
        return "{" + " Имя='" + getFirstName() + '\'' +
                " Фамилия=" + getLastName() +
                " Отдел=" + getOffice() +
                " Зарабатная плата=" + getSalary() +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, LastName, office, salary);
    }

    @Override
    public boolean equals(Object obj) {
        Employee employee = (Employee) obj;
        if (this == employee) {
            return true;
        } else if ((this.firstName.equals(employee.getFirstName())) &&
                (this.LastName.equals(employee.getLastName())) && (this.office == office) && (this.salary == salary)) {
            return true;
        } else
        return false;
    }
}
