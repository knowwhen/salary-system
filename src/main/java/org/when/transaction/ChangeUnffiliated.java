package org.when.transaction;

import org.when.employee.Affiliation;
import org.when.employee.Employee;
import org.when.employee.NoAffiliation;

public class ChangeUnffiliated extends ChangeAffiliation {

    public ChangeUnffiliated(Integer employeeId, Integer memberId) {
        super(employeeId, memberId);
    }

    @Override
    Affiliation getAffiliation() {
        return new NoAffiliation();
    }

    @Override
    void recordMembership(Employee employee) {
        Affiliation affiliation = getAffiliation();
        if (affiliation instanceof NoAffiliation) {
            database.removeUnionMember(memberId);
        }
    }

}
