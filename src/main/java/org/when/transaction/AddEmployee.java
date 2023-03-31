package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.*;
import org.when.employee.PaymentClassification;

public abstract class AddEmployee implements Transaction {
    private PayrollDatabase payrollDatabase;
    private int employeeId;
    private String name;
    private String address;

    public AddEmployee(int employeeId, String name, String address) {
        this.payrollDatabase = PayrollDatabase.getInstance();
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
    }

    @Override
    public void execute() {
        Employee employee = new SalariedEmployee(employeeId, name, address);
        employee.setClassification(getClassification());
        employee.setSchedule(getSchedule());
        employee.setMethod(getMethod());
        payrollDatabase.addEmployee(employeeId, employee);
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    public abstract PaymentMethod getMethod();
}
