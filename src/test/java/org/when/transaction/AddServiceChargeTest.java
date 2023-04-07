package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.PayrollDatabase;
import org.when.employee.Employee;
import org.when.employee.ServiceCharge;
import org.when.employee.UnionAffiliation;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class AddServiceChargeTest {
    private PayrollDatabase database;

    @Before
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    @Test
    public void test_add_service_charge() {
        int employeeId = 1;
        int memberId = 11;
        LocalDate today = LocalDate.now();
        double serviceCharge = 12.5;
        AddHourlyEmployee addEmployee = new AddHourlyEmployee(employeeId, "Hourly Employee", "Somewhere", 1.0);
        addEmployee.execute();

        Employee employee = database.findEmployee(employeeId);
        UnionAffiliation unionAffiliation = new UnionAffiliation(memberId, serviceCharge);
        employee.addAffiliation(unionAffiliation);

        database.addUnionMember(memberId, employee);

        AddServiceCharge addServiceCharge = new AddServiceCharge(memberId, today, serviceCharge);
        addServiceCharge.execute();

        ServiceCharge charge = unionAffiliation.getServiceCharge(today);
        assertEquals(serviceCharge, charge.getAmount(), 0);
    }
}