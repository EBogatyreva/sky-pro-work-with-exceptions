package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;

import java.util.Collection;

public interface EmployeeGetByOficce {
    Collection<Employee> findEmployeeByOffice(Integer office) throws NotFoundException;
    //Collection<Employee> sortedEmployeeByOffice();

    Collection<Employee> min(Integer office) throws NotFoundException;

    Collection<Employee> max(Integer office) throws NotFoundException;

    Collection<Employee> sortedEmployeeByOffice();
}
