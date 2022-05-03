package pro.sky.skyproworkwithexceptions.service.impl;

import pro.sky.skyproworkwithexceptions.data.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeConstant {

    public static final Map<Integer, Employee> EMPLOYEES_MAP = new HashMap<>(Map.of(
            0, new Employee("Иван", "Иванов", 1, 30_000),
            1, new Employee("Владимир", "Соколов", 1, 50_000),
            2, new Employee("Анна", "Миронова", 2, 70_000),
            3, new Employee("Сергей", "Васильев", 3, 100_000)
    ));

}