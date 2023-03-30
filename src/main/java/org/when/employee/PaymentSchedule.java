package org.when.employee;

import java.time.LocalDate;

public interface PaymentSchedule {
    boolean isPayDay(LocalDate date);
}
