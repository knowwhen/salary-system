package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.*;
import org.when.employee.classification.CommissionedClassification;
import org.when.employee.PaymentClassification;

import java.time.LocalDate;
import java.util.Objects;

public class AddSalesReceipt implements Transaction {
    private PayrollDatabase database;
    private Integer employeeId;
    private LocalDate date;
    private Double amount;

    public AddSalesReceipt(int employeeId, LocalDate date, double amount) {
        this.database = PayrollDatabase.getInstance();
        this.employeeId = employeeId;
        this.date = date;
        this.amount = amount;
    }

    @Override
    public void execute() {
        Employee employee = database.findEmployee(employeeId);
        if (Objects.nonNull(employee)) {
            addSalesReceipt(employee);
        } else {
            throw new RuntimeException("Unknown employee: " + employeeId);
        }
    }

    private void addSalesReceipt(Employee employee) {
        PaymentClassification classification = employee.getClassification();
        if (classification instanceof CommissionedClassification) {
            CommissionedClassification commissionedClassification = (CommissionedClassification) classification;
            SalesReceipt salesReceipt = new SalesReceipt(date, amount);
            commissionedClassification.addSalesReceipt(salesReceipt);
        } else {
            throw new RuntimeException("Non-Commissioned employee can not add sales receipt!");
        }
    }
}
