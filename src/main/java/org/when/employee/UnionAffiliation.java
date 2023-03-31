package org.when.employee;

import java.time.LocalDate;

public class UnionAffiliation implements Affiliation {
    private Integer memberId;
    private Double serviceCharge;

    public UnionAffiliation(Integer memberId, Double serviceCharge) {
        this.memberId = memberId;
        this.serviceCharge = serviceCharge;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public ServiceCharge getServiceCharge(LocalDate date) {
        return new ServiceCharge(date, serviceCharge);
    }

    public void setServiceCharge(Double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public void addServiceCharge(LocalDate date, Double serviceCharge) {
        // todo:
        System.out.println("add service charge:" + date + "/" + serviceCharge);
    }
}
