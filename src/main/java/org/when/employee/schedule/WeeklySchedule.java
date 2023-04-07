package org.when.employee.schedule;

import org.when.employee.PaymentSchedule;

import java.time.LocalDate;

public class WeeklySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDay(LocalDate date) {
        return false;
    }
}
