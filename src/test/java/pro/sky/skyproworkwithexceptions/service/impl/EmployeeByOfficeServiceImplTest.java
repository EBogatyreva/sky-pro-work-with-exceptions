package pro.sky.skyproworkwithexceptions.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproworkwithexceptions.data.Employee;

import java.util.Comparator;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

import static pro.sky.skyproworkwithexceptions.service.impl.EmployeeConstant.EMPLOYEES_MAP;

@ExtendWith(MockitoExtension.class)
class EmployeeByOfficeServiceImplTest {
    @Mock
    private EmployeeByOfficeServiceImpl employeeByOfficeServiceMock;
    @InjectMocks
    private EmployeeByOfficeServiceImpl out;

    @Test
    void getEmployeeList() {
        assertEquals(EMPLOYEES_MAP, out.getEmployeeList());
    }

    @Test
    void findEmployeeByOffice() {
        assertEquals(EMPLOYEES_MAP.values().stream()
                .filter(employee -> employee.getOffice() == 1)
                .collect(Collectors.toList()), out.findEmployeeByOffice(1));
    }

    @Test
    void min() {
        assertEquals(EMPLOYEES_MAP.values().stream()
                .filter(employee -> employee.getOffice() == 1)
                .min(Comparator.comparingInt(employee -> employee.getSalary()))
                .stream().collect(Collectors.toList()), out.min(1));
    }

    @Test
    void max() {
        assertEquals(EMPLOYEES_MAP.values().stream()
                .filter(employee -> employee.getOffice() == 1)
                .max(Comparator.comparingInt(employee -> employee.getSalary()))
                .stream().collect(Collectors.toList()), out.max(1));
    }

    @Test
    void sortedEmployeeByOffice() {
        assertEquals(EMPLOYEES_MAP.values().stream()
                .sorted(Comparator.comparing(Employee::getOffice))
                .collect(Collectors.toList()), out.sortedEmployeeByOffice());
    }
}