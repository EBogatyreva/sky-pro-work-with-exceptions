package pro.sky.skyproworkwithexceptions.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproworkwithexceptions.data.Employee;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static pro.sky.skyproworkwithexceptions.service.impl.EmployeeConstant.EMPLOYEES_MAP;

@ExtendWith(MockitoExtension.class)
class EmployeeByOfficeServiceImplTest {
    @Mock
    private EmployeeByOfficeServiceImpl employeeByOfficeServiceMock;
    @InjectMocks
    private EmployeeByOfficeServiceImpl out;

    @Test
    void getEmployeeList() {
        when(employeeByOfficeServiceMock.getEmployeeList())
                .thenReturn(EMPLOYEES_MAP);
        assertEquals(EMPLOYEES_MAP, out.getEmployeeList());
    }

    @Test
    void findEmployeeByOffice() {
        when(employeeByOfficeServiceMock.findEmployeeByOffice(1))
                .thenReturn((Collection<Employee>) EMPLOYEES_MAP);
        assertEquals(EMPLOYEES_MAP, out.findEmployeeByOffice(1));
    }

    @Test
    void min() {
        when(employeeByOfficeServiceMock.getEmployeeList())
                .thenReturn(EMPLOYEES_MAP);
        assertEquals(50_000, out.max(1));

    }

    @Test
    void max() {
        when(employeeByOfficeServiceMock.getEmployeeList())
                .thenReturn(EMPLOYEES_MAP);
        assertEquals(30_000, out.min(1));
    }
}