package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.PayrollDatabase;
import org.when.employee.Employee;
import org.when.employee.PaymentClassification;
import org.when.employee.PaymentSchedule;
import org.when.employee.classification.HourlyClassification;
import org.when.employee.schedule.WeeklySchedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChangeHourlyClassificationTest {
    private PayrollDatabase database;

    @Before
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    @Test
    public void test_change_hourly_classification() {
        int employeeId = 3;
        double rate = 27.52;
        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(employeeId, "Commissioned Employee", "Somewhere", 2500.00, 3.2);
        addCommissionedEmployee.execute();

        ChangeHourlyClassification changeHourlyClassification = new ChangeHourlyClassification(employeeId, rate);
        changeHourlyClassification.execute();

        Employee employee = database.findEmployee(employeeId);

        PaymentClassification classification = employee.getClassification();
        assertNotNull(classification);
        HourlyClassification hourlyClassification = (HourlyClassification) classification;
        assertEquals(rate, hourlyClassification.getRate(), 0);

        PaymentSchedule schedule = employee.getSchedule();
        assertNotNull(schedule);
        WeeklySchedule weeklySchedule = (WeeklySchedule) schedule;
        assertNotNull(weeklySchedule);

    }
}