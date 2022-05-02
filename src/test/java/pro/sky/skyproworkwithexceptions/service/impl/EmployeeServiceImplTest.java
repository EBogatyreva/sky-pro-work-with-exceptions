package pro.sky.skyproworkwithexceptions.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.skyproworkwithexceptions.data.Employee;
import pro.sky.skyproworkwithexceptions.exception.NotFoundException;
import pro.sky.skyproworkwithexceptions.service.impl.EmployeeServiceImpl;


import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl out = new EmployeeServiceImpl();

    @Test
    void getEmployeeList_shouldReturnTrue() {
        out.findEmployee("Иван", "Иванов");
    }

    @Test
    void addNewEmployee() {
        Employee expected = new Employee("L", "L", 1, 30_00);
        assertEquals(0, out.getEmployeeList().size());//мы так делаем всегда? проверяем размер на 0?
        assertFalse(out.getEmployeeList().contains(expected));
        String actual = out.addNewEmployee("L", "L", 1, 30_00);
        assertEquals(expected, actual);
        assertEquals(1, out.getEmployeeList().size());
        assertTrue(out.getEmployeeList().contains(expected));
    }

    @Test
    void delEmployee() {
        Employee expected = new Employee("Иван", "Иванов", 1, 30_00);
        assertEquals(1, out.getEmployeeList().size());
        assertTrue(out.getEmployeeList().contains(expected));
        String actual = out.delEmployee("Иван", "Иванов", 1, 30_00);
        assertEquals(expected, actual);
        assertTrue(out.getEmployeeList().isEmpty());
        assertFalse(out.getEmployeeList().contains(expected));
    }

    @Test
    void findEmployee() {
        String expected = out.addNewEmployee("L", "L", 1, 30_00);
        assertEquals(expected, out.findEmployee("L", "L"));
    }

    @Test
    void shouldThrowExceptionWhenNotfindEmployee() {
        assertEquals(0, out.getEmployeeList().size());
        assertThrows(NotFoundException.class, () -> out.findEmployee("S", "S"));
    }
}