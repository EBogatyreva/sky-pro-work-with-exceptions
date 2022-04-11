package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;

import java.util.Map;

public interface EmployeeGetByOficce {
    Map<Integer, Employee> findEmployeeByOffice(Integer office) throws NotFoundException;
}
