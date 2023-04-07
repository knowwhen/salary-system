package org.when.transaction;

import org.when.employee.Employee;

import java.util.Optional;
import java.util.function.BiConsumer;

public class ChangeEmployee extends AbstractChange {

    public ChangeEmployee(Integer employeeId) {
        super(employeeId);
    }

    @Override
    public void change(Employee employee) {
        // todo: maybe this is unnecessary
        System.out.println("change method:" + employee.getEmployeeId());
    }

    public <V> void doChange(BiConsumer<Employee, V> acceptor, V value) {
        Optional<Employee> optional = getEmployee();
        Employee employee = optional.orElseThrow(() -> new RuntimeException("Unknown employee with id: " + getEmployeeId()));
        acceptor.accept(employee, value);
    }

}
