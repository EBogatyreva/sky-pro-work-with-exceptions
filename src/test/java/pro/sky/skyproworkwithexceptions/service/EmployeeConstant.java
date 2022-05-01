package pro.sky.skyproworkwithexceptions.service;

import pro.sky.skyproworkwithexceptions.data.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeConstant {
    public static final Employee EMPLOYEE1 = new Employee("Иван", "Иванов", 1, 30_00);
    public static final Employee EMPLOYEE2 = new Employee("Владимир", "Соколов", 1, 50_000);
    public static final Employee EMPLOYEE3 = new Employee("Анна", "Миронова", 2, 70_000);
    public static final Employee EMPLOYEE4 = new Employee("Сергей", "Васильев", 2, 70_000);
    public static final Employee EMPLOYEE5 = new Employee("Елизавета", "Ковалева", 3, 50_000);

    public static final List<Employee> Employee_LIST = List.of(
            EMPLOYEE1,
            EMPLOYEE2,
            EMPLOYEE3,
            EMPLOYEE4,
            EMPLOYEE5
    );

/*   почему не работает добавление в Map?!
        private Map<Integer, String> employees = new HashMap<>();
                employees.put(1, new Employee("Иван", "Иванов", 1, 30_000));
                employees.put(2, new Employee("Владимир", "Соколов", 1, 50_000));
                employees.put(3, new Employee("Анна", "Миронова", 2, 70_000));
                employees.put(4, new Employee("Сергей", "Васильев", 3, 100_000));*/
}
