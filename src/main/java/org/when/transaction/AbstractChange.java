package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.Employee;

import java.util.Optional;

public abstract class AbstractChange implements Transaction {
    protected final PayrollDatabase database;
    private final Integer employeeId;

    public AbstractChange(Integer employeeId) {
        this.database = PayrollDatabase.getInstance();
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    @Override
    public void execute() {
        Optional<Employee> optional = getEmployee();
        Employee employee = optional.orElseThrow(() -> new RuntimeException("Unknown employee with id: " + employeeId));
        change(employee);
    }

    protected Optional<Employee> getEmployee() {
        Employee employee = database.findEmployee(employeeId);
        return Optional.ofNullable(employee);
    }

    public abstract void change(Employee employee);
}
