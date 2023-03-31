package org.when.employee;

public class CommissionedEmployee extends Employee {
    private Double salary;
    private Double rate;

    public CommissionedEmployee(Integer employeeId, String name, String address) {
        this(employeeId, name, address, 0.00, 0.00);
    }

    public CommissionedEmployee(Integer employeeId, String name, String address, Double salary, Double rate) {
        super(employeeId, name, address);
        this.salary = salary;
        this.rate = rate;
    }

}
