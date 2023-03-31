package org.when.employee;

import java.time.Duration;
import java.time.LocalDate;

public class TimeCard {
    private LocalDate date;
    private Duration hours;

    public TimeCard(LocalDate data, Duration hours) {
        this.date = data;
        this.hours = hours;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Duration getHours() {
        return hours;
    }

    public void setHours(Duration hours) {
        this.hours = hours;
    }
}
