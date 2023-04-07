package org.when.transaction;

import org.when.employee.PaymentClassification;
import org.when.employee.PaymentMethod;
import org.when.employee.PaymentSchedule;
import org.when.employee.classification.HourlyClassification;

public class AddHourlyEmployee extends AddEmployee {
    private final double rate;

    public AddHourlyEmployee(int employeeId, String name, String address, Double rate) {
        super(employeeId, name, address);
        this.rate = rate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification(rate);
    }

    @Override
    public PaymentSchedule getSchedule() {
        return null;
    }

    @Override
    public PaymentMethod getMethod() {
        return null;
    }
}
