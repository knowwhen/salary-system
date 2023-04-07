package org.when.transaction;

import org.when.employee.Affiliation;
import org.when.employee.Employee;

public abstract class ChangeAffiliation extends AbstractChange {
    protected final Integer memberId;

    public ChangeAffiliation(Integer employeeId, Integer memberId) {
        super(employeeId);
        this.memberId = memberId;
    }

    @Override
    public void change(Employee employee) {
        recordMembership(employee);
        employee.addAffiliation(getAffiliation());
    }

    abstract Affiliation getAffiliation();

    abstract void recordMembership(Employee employee);
}
