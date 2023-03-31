package org.when.transaction;

import org.when.PayrollDatabase;
import org.when.employee.Affiliation;
import org.when.employee.Employee;
import org.when.employee.UnionAffiliation;

import java.time.LocalDate;
import java.util.Objects;

public class AddServiceCharge implements Transaction {
    private PayrollDatabase database;
    private Integer memberId;
    private LocalDate date;
    private Double serviceCharge;

    public AddServiceCharge(Integer memberId, LocalDate date, Double serviceCharge) {
        this.database = PayrollDatabase.getInstance();
        this.memberId = memberId;
        this.date = date;
        this.serviceCharge = serviceCharge;
    }

    @Override
    public void execute() {
        Employee employee = database.findEmployeeByMemberId(memberId);
        if (Objects.nonNull(employee)) {
            addServiceCharge(employee);
        } else {
            throw new RuntimeException("Unknown employee: " + memberId);
        }
    }

    private void addServiceCharge(Employee employee) {
        Affiliation affiliation = employee.getAffiliation();
        if (affiliation instanceof UnionAffiliation) {
            UnionAffiliation unionAffiliation = (UnionAffiliation) affiliation;
            unionAffiliation.addServiceCharge(date, serviceCharge);
        } else {
            throw new RuntimeException("No-Affiliation employee can not add service charge!");
        }
    }
}
