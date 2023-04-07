package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.PayrollDatabase;
import org.when.employee.Employee;

import static org.junit.Assert.*;

public class ChangeEmployeeTest {

    private PayrollDatabase database;

    @Before
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    @Test
    public void test_change_employee_name() {
        int employeeId = 2;
        String newName = "New Name";
        AddHourlyEmployee hourlyEmployee = new AddHourlyEmployee(2, "Hourly Employee", "Anywhere");
        hourlyEmployee.execute();
        ChangeEmployee changeName = new ChangeEmployee(employeeId);
        changeName.doChange(Employee::setName, newName);

        Employee employee = database.findEmployee(employeeId);
        assertEquals(newName, employee.getName());
    }
}