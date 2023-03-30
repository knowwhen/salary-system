package org.when.employee;

import java.time.LocalDate;

public class MonthlySchedule implements PaymentSchedule {
    @Override
    public boolean isPayDay(LocalDate date) {
        return false;
    }
}
