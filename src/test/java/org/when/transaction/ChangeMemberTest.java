package org.when.transaction;

import org.junit.Before;
import org.junit.Test;
import org.when.PayrollDatabase;
import org.when.employee.Affiliation;
import org.when.employee.Employee;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ChangeMemberTest {
    private PayrollDatabase database;

    @Before
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    @Test
    public void test_change_member() {
        int employeeId = 2;
        int memberId = 1234;
        Double dues = 99.42;
        AddHourlyEmployee addHourlyEmployee = new AddHourlyEmployee(employeeId, "HourlyEmployee", "Some place", 15.25);
        addHourlyEmployee.execute();

        ChangeMember changeMember = new ChangeMember(employeeId, memberId, dues);
        changeMember.execute();

        Employee employee = database.findEmployee(employeeId);
        assertNotNull(employee);
        Affiliation affiliation = employee.getAffiliation();
        assertNotNull(affiliation);
        assertEquals(dues, affiliation.getDues());

        Employee member = database.findEmployeeByMemberId(memberId);
        assertNotNull(member);
        assertEquals(employee, member);

    }
}