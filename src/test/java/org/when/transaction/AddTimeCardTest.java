package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.PayrollDatabase;
import org.when.employee.Employee;
import org.when.employee.PaymentClassification;
import org.when.employee.TimeCard;
import org.when.employee.classification.HourlyClassification;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class AddTimeCardTest {
    private PayrollDatabase database;

    @Before
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    @Test
    public void test_add_time_card() {
        int employeeId = 1;
        LocalDate today = LocalDate.now();
        long hours = 8;
        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(employeeId, "Hourly Employee", "Home today and gone tomorrow", 1.0);
        addHourlyEmployee.execute();

        AddTimeCard addTimeCard = new AddTimeCard(employeeId, today, hours);
        addTimeCard.execute();

        Employee employee = database.findEmployee(employeeId);
        PaymentClassification classification = employee.getClassification();
        HourlyClassification hourlyClassification = (HourlyClassification) classification;
        assertNotNull(classification);

        Optional<TimeCard> optional = hourlyClassification.getTimeCard(today);
        assertTrue(optional.isPresent());
        TimeCard timeCard = optional.get();
        assertEquals(hours, timeCard.getHours().toHours(), 0);
    }
}