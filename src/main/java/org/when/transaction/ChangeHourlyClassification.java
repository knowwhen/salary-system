package org.when.transaction;

import org.when.employee.PaymentClassification;
import org.when.employee.PaymentSchedule;
import org.when.employee.classification.HourlyClassification;
import org.when.employee.schedule.WeeklySchedule;

public class ChangeHourlyClassification extends ChangeClassification {
    private final double rate;

    public ChangeHourlyClassification(Integer employeeId) {
        this(employeeId, 0);
    }

    public ChangeHourlyClassification(Integer employeeId, double rate) {
        super(employeeId);
        this.rate = rate;
    }

    @Override
    PaymentClassification getClassification() {
        return new HourlyClassification(rate);
    }

    @Override
    PaymentSchedule getSchedule() {
        return new WeeklySchedule();
    }
}
