package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;

import java.util.Collection;

import java.util.Map;


public interface EmployeeGetByOficce {
    Map<Integer, Employee> getEmployeeList();

    Collection<Employee> findEmployeeByOffice(Integer office) throws NotFoundException;

    Collection<Employee> min(Integer office) throws NotFoundException;

    Collection<Employee> max(Integer office) throws NotFoundException;

    Collection<Employee> sortedEmployeeByOffice();
}
