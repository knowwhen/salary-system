package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.Employee;
import org.when.employee.PaymentClassification;
import org.when.employee.PaymentSchedule;

import java.util.Objects;

public abstract class ChangeClassification implements Transaction {
    private final PayrollDatabase database;
    private final Integer employeeId;

    public ChangeClassification(Integer employeeId) {
        this.database = PayrollDatabase.getInstance();
        this.employeeId = employeeId;
    }

    @Override
    public void execute() {
        Employee employee = database.findEmployee(employeeId);
        if (Objects.nonNull(employee)) {
            employee.setClassification(getClassification());
            employee.setSchedule(getSchedule());
        }
    }

    abstract PaymentClassification getClassification();

    abstract PaymentSchedule getSchedule();
}
