package org.when.employee.classification;

import org.when.employee.PaymentClassification;
import org.when.employee.TimeCard;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HourlyClassification implements PaymentClassification {
    private final double rate;
    private final List<TimeCard> timeCards;

    public HourlyClassification(double rate) {
        this.rate = rate;
        this.timeCards = new ArrayList<>();
    }

    public double getRate() {
        return rate;
    }

    public void addTimeCard(TimeCard timeCard) {
        timeCards.add(timeCard);
    }

    public Optional<TimeCard> getTimeCard(LocalDate date) {
        return timeCards.stream()
                .filter(e -> e.getDate().equals(date))
                .findAny();
    }

    public List<TimeCard> getTimeCards() {
        return timeCards;
    }
}
