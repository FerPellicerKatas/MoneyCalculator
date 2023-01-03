package model;

import java.util.ArrayList;

public class ExchangeRateSet {

    private final ArrayList<ExchangeRate> exchangeRates;

    public ExchangeRateSet() {
        this.exchangeRates = new ArrayList<>();
    }

    public ArrayList<ExchangeRate> getExchangeRateSet() {
        return exchangeRates;
    }

    public void add(ExchangeRate e) {
        exchangeRates.add(e);
    }

    public void remove(ExchangeRate e) {
        exchangeRates.remove(e);
    }

    public boolean contains(ExchangeRate e) {
        return exchangeRates.contains(e);
    }

    public ExchangeRate get(int index) {
        return exchangeRates.get(index);
    }

    public float getRate(Currency from, Currency to) {
        for (ExchangeRate rate : exchangeRates) {
            if (rate.getCurrencyFrom().equals(from) && rate.getCurrencyTo().equals(to)) {
                return rate.getRate();
            }
            if (rate.getCurrencyFrom().equals(to) && rate.getCurrencyTo().equals(from)) {
                return 1 / (rate.getRate());
            }
        }
        return 0;
    }

    public ExchangeRate[] toArray() {
        return exchangeRates.toArray(new ExchangeRate[exchangeRates.size()]);
    }
}