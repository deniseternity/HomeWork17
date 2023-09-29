package pro.Sky.Skypro.service;

import org.springframework.stereotype.Service;
import pro.Sky.Skypro.model.Employee;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
            try {
                throw new EmployeeAlreadyAddedException();
            } catch (EmployeeAlreadyAddedException e) {
                throw new RuntimeException(e);
            }
        }

        employees.add(employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            try {
                throw new EmployeeNotFoundException();
            } catch (EmployeeNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        employees.remove(employee);
        return employee;
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (!employees.contains(employee)) {
            try {
                throw new EmployeeNotFoundException();
            } catch (EmployeeNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        return employee;
    }

    @Override //ss
    public Collection<Employee> findAll() {
        return employees;
    }
}
