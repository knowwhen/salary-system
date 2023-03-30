package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.DataBase;
import org.when.employee.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AddSalariedEmployeeTest {

    private DataBase dataBase;
    private AddSalariedEmployee addSalariedEmployee;

    @Before
    public void setUp() throws Exception {
        dataBase = new DataBase();
    }

    @Test
    public void test_add_salaried_employee() {
        int empId = 1;
        String name = "Bob";
        double salary = 1000.00;
        addSalariedEmployee = new AddSalariedEmployee(empId, name, "Home", salary);
        addSalariedEmployee.execute();
        Employee employee = dataBase.findEmployee(empId);

        assertEquals(name, employee.getName());

        PaymentClassification classification = employee.getClassification();
        SalariedClassification salariedClassification = (SalariedClassification) classification;
        assertEquals(salary, salariedClassification.getSalary(), 0);

        PaymentSchedule paymentSchedule = employee.getSchedule();
        assertNotNull(paymentSchedule);
        MonthlySchedule monthlySchedule = (MonthlySchedule) paymentSchedule;

        PaymentMethod paymentMethod = employee.getMethod();
        HoldMethod holdMethod = (HoldMethod) paymentMethod;
        assertNotNull(paymentMethod);
    }
}