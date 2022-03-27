package pro.sky.skyproworkwithexceptions;

import java.util.Objects;
public class Employee implements EmployeeInterface {
    private String firstName;
    private String LastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.LastName = lastName;
    }

    public Employee() {

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
        return "{" + " Имя ='" + getFirstName() + '\'' +
                " Фамилия=" + getLastName() +
                '}';
    }

    @Override
    public int hashCode() {return Objects.hash(firstName, LastName);
    }

/*    @Override
    public boolean equals(Employee employee) {
        if (this == employee) {
            return true;
        } else if ((this.LastName == employee.getFirstName()) && (this.LastName == employee.getLastName())) {
            return true;
        } else
            return false;
    }*/
}
