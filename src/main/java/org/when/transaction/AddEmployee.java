package org.when.transaction;

import org.when.employee.*;

public abstract class AddEmployee implements Transaction {
    private int employeeId;
    private String name;
    private String address;

    public AddEmployee(int employeeId, String name, String address) {
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
        // DataBase.addEmployee(employeeId, employee);
    }

    public abstract PaymentClassification getClassification();

    public abstract PaymentSchedule getSchedule();

    public abstract PaymentMethod getMethod();
}
