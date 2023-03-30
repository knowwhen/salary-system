package org.when.transaction;

import org.when.employee.*;

public class AddSalariedEmployee extends AddEmployee {

    private final double salary;

    public AddSalariedEmployee(int employeeId, String name, String address) {
        this(employeeId, name, address, 0.00);
    }

    @Override
    public PaymentClassification getClassification() {
        return new SalariedClassification();
    }

    @Override
    public PaymentSchedule getSchedule() {
        return new MonthlySchedule();
    }

    @Override
    public PaymentMethod getMethod() {
        return new HoldMethod();
    }

    public AddSalariedEmployee(int employeeId, String name, String address, double salary) {
        super(employeeId, name, address);
        this.salary = salary;
    }
}
