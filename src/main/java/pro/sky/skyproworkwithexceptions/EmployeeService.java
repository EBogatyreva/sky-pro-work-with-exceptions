package pro.sky.skyproworkwithexceptions;

public interface EmployeeService {

    String addNewEmployee(String firstName, String lastName) throws OverFlowException, BadRequest;

    String delEmployee(String firstName, String lastName) throws NotFoundException;

    String findEmployee(String firstName, String lastName) throws NotFoundException;

    String getDescriptionEmployee(int number);

    boolean equals(Object obj);

}
