package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.PayrollDatabase;
import org.when.employee.classification.CommissionedClassification;
import org.when.employee.Employee;
import org.when.employee.PaymentClassification;
import org.when.employee.SalesReceipt;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

public class AddSalesReceiptTest {
    private PayrollDatabase database;

    @Before
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    @Test
    public void test_add_sales_receipt() {
        int employeeId = 1;
        LocalDate today = LocalDate.now();
        double amount = 1000.00;
        AddCommissionedEmployee addCommissionedEmployee = new AddCommissionedEmployee(employeeId, "Commissioned Employee", "HHH", 500.00, 0.20);
        addCommissionedEmployee.execute();

        AddSalesReceipt addSalesReceipt = new AddSalesReceipt(employeeId, today, amount);
        addSalesReceipt.execute();

        Employee employee = database.findEmployee(employeeId);
        PaymentClassification classification = employee.getClassification();
        assertNotNull(classification);

        CommissionedClassification commissionedClassification = (CommissionedClassification) classification;
        Optional<SalesReceipt> optional = commissionedClassification.getSalesReceipt(today);
        assertTrue(optional.isPresent());
        SalesReceipt salesReceipt = optional.get();
        assertEquals(amount, salesReceipt.getAmount(), 0);
    }
}