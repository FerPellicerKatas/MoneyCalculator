package model;

public final class ExchangeRate {

    private final Currency from;
    private final Currency to;
    private final float rate;

    public ExchangeRate(Currency currencyFrom, Currency currencyTo, float rate) {
        this.from = currencyFrom;
        this.to = currencyTo;
        this.rate = rate;
    }

    public Currency getCurrencyFrom() {
        return from;
    }

    public Currency getCurrencyTo() {
        return to;
    }

    public float getRate() {
        return rate;
    }
}