package org.when.employee.classification;

import org.when.employee.PaymentClassification;

public class SalariedClassification implements PaymentClassification {
    private Double salary;

    public SalariedClassification(Double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}
