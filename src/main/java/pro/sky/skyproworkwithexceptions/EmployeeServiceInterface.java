package pro.sky.skyproworkwithexceptions;

public interface EmployeeServiceInterface {
    String addNewEmployee(String firstName, String lastName) throws OverFlowException;
    String delEmployee(String firstName, String lastName) throws NotFoundException;

    String findEmployee(String firstName, String lastName) throws NotFoundException;

    String getDescriptionEmployee(int number);

   // boolean equals(Employee employee);
}
