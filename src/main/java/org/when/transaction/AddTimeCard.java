package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.Employee;
import org.when.employee.classification.HourlyClassification;
import org.when.employee.PaymentClassification;
import org.when.employee.TimeCard;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

public class AddTimeCard implements Transaction {
    private PayrollDatabase database;
    private Integer employeeId;
    private LocalDate date;
    private Long hours;

    public AddTimeCard(Integer employeeId, LocalDate date, Long hours) {
        this.employeeId = employeeId;
        this.date = date;
        this.hours = hours;
        this.database = PayrollDatabase.getInstance();
    }

    @Override
    public void execute() {
        Employee employee = database.findEmployee(employeeId);
        if (Objects.nonNull(employee)) {
            addTimeCard(employee);
        } else {
            throw new RuntimeException("Unknown employee: " + employeeId);
        }
    }

    private void addTimeCard(Employee employee) {
        PaymentClassification classification = employee.getClassification();
        if (classification instanceof HourlyClassification) {
            HourlyClassification hourlyClassification = (HourlyClassification) classification;
            TimeCard timeCard = new TimeCard(date, Duration.ofHours(hours));
            hourlyClassification.addTimeCard(timeCard);
        } else {
            throw new RuntimeException("Non-Hourly employee can not add time card!");
        }
    }
}
