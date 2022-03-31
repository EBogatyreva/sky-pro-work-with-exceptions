package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exceptions.BadRequest;
import pro.sky.skyproworkwithexceptions.exceptions.NotFoundException;
import pro.sky.skyproworkwithexceptions.exceptions.OverFlowException;

import java.util.List;

public interface EmployeeService {
    List<Employee> getEmployeeList();


    String addNewEmployee(String firstName, String lastName) throws OverFlowException, BadRequest;

    String delEmployee(String firstName, String lastName) throws NotFoundException;

    String findEmployee(String firstName, String lastName) throws NotFoundException;

    String getDescriptionEmployee(int number);

    boolean equals(Object obj);

}
