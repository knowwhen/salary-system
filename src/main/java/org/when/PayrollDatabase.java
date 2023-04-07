package org.when;

import org.when.employee.Employee;

import java.util.HashMap;
import java.util.Map;

public class PayrollDatabase {
    private static PayrollDatabase INSTANCE;

    private PayrollDatabase() {
    }

    public static PayrollDatabase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PayrollDatabase();
        }
        return INSTANCE;
    }

    private final Map<Integer, Employee> employees = new HashMap<>();
    private final Map<Integer, Employee> unionMembers = new HashMap<>();

    public Employee findEmployee(int employeeId) {
        return employees.get(employeeId);
    }

    public Employee findEmployeeByMemberId(int memberId) {
        return unionMembers.get(memberId);
    }

    public void addEmployee(Integer employeeId, Employee employee) {
        employees.put(employeeId, employee);
    }

    public void deleteEmployee(Integer employeeId) {
        employees.remove(employeeId);
    }

    public void addUnionMember(int memberId, Employee employee) {
        unionMembers.put(memberId, employee);
    }

    public void removeUnionMember(Integer memberId) {
        unionMembers.remove(memberId);
    }
}
