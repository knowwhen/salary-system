package org.when.transaction;

import org.when.employee.Employee;
import org.when.employee.PaymentClassification;
import org.when.employee.PaymentSchedule;

public abstract class ChangeClassification extends AbstractChange {
    public ChangeClassification(Integer employeeId) {
        super(employeeId);
    }

    @Override
    public void change(Employee employee) {
        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
    }

    abstract PaymentClassification getClassification();

    abstract PaymentSchedule getSchedule();
}
