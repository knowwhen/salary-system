package org.when.transaction;

import org.when.employee.*;
import org.when.employee.classification.CommissionedClassification;
import org.when.employee.PaymentClassification;
import org.when.employee.method.HoldMethod;
import org.when.employee.schedule.MonthlySchedule;

public class AddCommissionedEmployee extends AddEmployee {
    private Double salary;
    private Double rate;

    public AddCommissionedEmployee(int employeeId, String name, String address, Double salary, Double rate) {
        super(employeeId, name, address);
        this.salary = salary;
        this.rate = rate;
    }

    @Override
    public PaymentClassification getClassification() {
        return new CommissionedClassification();
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
