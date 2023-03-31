package org.when.transaction;

import org.when.employee.*;
import org.when.employee.classification.HourlyClassification;
import org.when.employee.PaymentClassification;

public class AddHourlyEmployee extends AddEmployee {

    public AddHourlyEmployee(int employeeId, String name, String address) {
        super(employeeId, name, address);
    }

    @Override
    public PaymentClassification getClassification() {
        return new HourlyClassification();
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
