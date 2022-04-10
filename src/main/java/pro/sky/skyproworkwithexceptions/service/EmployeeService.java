package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.BadRequest;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.exception.OverFlowException;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Map<Integer, Employee> getEmployeeList();

   // String getDescriptionEmployee(String firstName, String lastName, int office, int salary) throws NotFoundException;

    List getDescriptionEmployee();

    String addNewEmployee(String firstName, String lastName, int office, int salary) throws OverFlowException, BadRequest;

    String delEmployee(String firstName, String lastName, int office, int salary) throws NotFoundException;

    String findEmployee(String firstName, String lastName, int office, int salary) throws NotFoundException;

    Object findEmployeeByOffice(Integer office) throws NotFoundException;

    //String getDescriptionEmployee(String firstName, String lastName) throws NotFoundException;

}