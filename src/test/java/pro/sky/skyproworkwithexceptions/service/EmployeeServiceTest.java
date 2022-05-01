package pro.sky.skyproworkwithexceptions.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.service.impl.EmployeeServiceImpl;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static pro.sky.skyproworkwithexceptions.service.EmployeeConstant.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    //у меня и сервис и хранилище в одном классе
    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private EmployeeServiceImpl out;

    @Test
    void getEmployeeList() {
        when(employeeServiceMock.getEmployeeList())
                .thenReturn(Employee_LIST);
        assertIterableEquals(Employee_LIST, out.getEmployeeList());
    }

       @Test
        void addNewEmployee() {
        assertNotNull(employeeServiceMock);//!
           Mockito.when(employeeServiceMock.addNewEmployee("Владимир", "Соколов", 1, 50_000)).thenReturn(String.valueOf(EMPLOYEE2));
        }
/*
        @Test
        void delEmployee() {
            Employee employee1 = new Employee(firstName, lastName, office, salary);
            if (!employees.containsValue(employee1)) {
                throw new NotFoundException();
            } else
                employees.values().remove(employee1);
            return "Cотрудник " + employee1 + " удалён";
        }
*/
    @Test
    void findEmployee() {
        when(employeeServiceMock.findEmployee("Иван", "Иванов"))
                .thenReturn("Иван", "Иванов");
    }
}