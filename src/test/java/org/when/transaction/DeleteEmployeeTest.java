package org.when.transaction;

import junit.framework.TestCase;
import org.when.PayrollDatabase;
import org.when.employee.Employee;

public class DeleteEmployeeTest extends TestCase {
    private PayrollDatabase database;

    @Override
    public void setUp() throws Exception {
        database = PayrollDatabase.getInstance();
    }

    public void test_delete_employee() {
        int employeeId = 3;
        AddSalariedEmployee addSalariedEmployee = new AddSalariedEmployee(employeeId, "3rd", "someplace", 100.00);
        addSalariedEmployee.execute();
        Employee newEmployee = database.findEmployee(employeeId);
        assertNotNull(newEmployee);

        DeleteEmployee deleteEmployee = new DeleteEmployee(employeeId);
        deleteEmployee.setParollDatabase(database);
        deleteEmployee.execute();
        Employee employee = database.findEmployee(employeeId);
        assertNull(employee);
    }
}