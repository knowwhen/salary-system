package org.when.transaction;

import org.when.employee.*;
import org.when.employee.PaymentClassification;
import org.when.employee.classification.SalariedClassification;
import org.when.employee.method.HoldMethod;
import org.when.employee.schedule.MonthlySchedule;

public class AddSalariedEmployee extends AddEmployee {

    private final double salary;

    public AddSalariedEmployee(int employeeId, String name, String address) {
        this(employeeId, name, address, 0.00);
    }

    public AddSalariedEmployee(int employeeId, String name, String address, double salary) {
        super(employeeId, name, address);
        this.salary = salary;
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification(salary);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    public PaymentMethod getMethod() {
        return new HoldMethod();
    }
}
