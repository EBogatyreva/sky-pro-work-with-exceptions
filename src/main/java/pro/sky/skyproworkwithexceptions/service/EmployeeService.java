package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.BadRequest;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.exception.OverFlowException;

import java.util.Map;

public interface EmployeeService {
    Map<Integer, Employee> getEmployeeList();

    String addNewEmployee(Integer index, String firstName, String lastName) throws OverFlowException, BadRequest;

    String delEmployee(Integer index, String firstName, String lastName) throws NotFoundException;

    String findEmployee(Integer index, String firstName, String lastName) throws NotFoundException;

    String getDescriptionEmployee(Integer index) throws NotFoundException;

    boolean equals(Object obj);

}