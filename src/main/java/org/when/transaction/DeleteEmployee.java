package org.when.transaction;

import org.when.PayrollDatabase;

public class DeleteEmployee implements Transaction {
    private PayrollDatabase database;
    private Integer employeeId;

    public DeleteEmployee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public void setParollDatabase(PayrollDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.deleteEmployee(employeeId);
    }
}
