package org.when.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private Integer employeeId;
    private String name;
    private String address;

    private PaymentClassification classification;
    private PaymentSchedule schedule;
    private PaymentMethod method;
    private final List<Affiliation> affiliations = new ArrayList<>();

    public Employee(Integer employeeId, String name, String address) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PaymentClassification getClassification() {
        return classification;
    }

    public void setClassification(PaymentClassification classification) {
        this.classification = classification;
    }

    public PaymentSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(PaymentSchedule schedule) {
        this.schedule = schedule;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public void addAffiliation(Affiliation affiliation) {
        affiliations.add(affiliation);
    }

    public Affiliation getAffiliation() {
        return affiliations.stream()
                .findAny()
                .orElse(null);
    }
}
