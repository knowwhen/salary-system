package org.when.employee.classification;

import org.when.employee.PaymentClassification;
import org.when.employee.SalesReceipt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommissionedClassification implements PaymentClassification {
    private final List<SalesReceipt> salesReceipts = new ArrayList<>();

    public void addSalesReceipt(SalesReceipt salesReceipt) {
        salesReceipts.add(salesReceipt);
    }

    public Optional<SalesReceipt> getSalesReceipt(LocalDate date) {
        return salesReceipts.stream()
                .filter(e -> e.getDate().equals(date))
                .findAny();
    }
}
