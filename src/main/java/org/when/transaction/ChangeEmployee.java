package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.Employee;

import java.util.Optional;
import java.util.function.BiConsumer;

public class ChangeEmployee implements Transaction {
    private final PayrollDatabase database;
    private final Integer employeeId;

    public ChangeEmployee(Integer employeeId) {
        this.database = PayrollDatabase.getInstance();
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {

    }

    public <V> void doChange(BiConsumer<Employee, V> acceptor, V value) {
        Optional<Employee> optional = findEmployee();
        Employee employee = optional.orElseThrow(() -> new RuntimeException("Unknown employee with id: " + employeeId));
        acceptor.accept(employee, value);
    }

    protected Optional<Employee> findEmployee() {
        Employee employee = database.findEmployee(employeeId);
        return Optional.ofNullable(employee);
    }

}
