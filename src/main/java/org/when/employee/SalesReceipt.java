package org.when.employee;

import java.time.LocalDate;

public class SalesReceipt {
    private LocalDate date;
    private Double amount;

    public SalesReceipt(LocalDate date, Double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
