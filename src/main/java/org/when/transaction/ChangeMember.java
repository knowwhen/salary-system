package org.when.transaction;

import org.when.employee.Affiliation;
import org.when.employee.Employee;
import org.when.employee.UnionAffiliation;

public class ChangeMember extends ChangeAffiliation {
    private final Double dues;

    public ChangeMember(int employeeId, int memberId, Double dues) {
        super(employeeId, memberId);
        this.dues = dues;
    }

    @Override
    Affiliation getAffiliation() {
        return new UnionAffiliation(memberId, dues);
    }

    @Override
    void recordMembership(Employee employee) {
        database.addUnionMember(memberId, employee);
    }
}
