 package test_unitaire;

public class Money {
    private int fAmount;
    private String fCurrency;

    public Money(int amount, String currency) {
        fAmount = amount;
        fCurrency = currency;
    }

    public int amount() {
        return fAmount;
    }

    public String currency() {
        return fCurrency;
    }

    public MoneyBag add(Money m) {
        Money[] bag = { this, m };
        return new MoneyBag(bag);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Money other = (Money) obj;
        return fAmount == other.fAmount && fCurrency.equals(other.fCurrency);
    }
}
