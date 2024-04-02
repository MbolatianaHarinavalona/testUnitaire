package test_unitaire;

import java.util.Vector;
class MoneyBag {
private Vector<Money> fMonies = new Vector<Money>();

MoneyBag(Money m1, Money m2) {
	appendMoney(m1); 
	appendMoney(m2);
	}

MoneyBag(Money bag[]) {
	for (int i = 0; i < bag.length; i++)
		appendMoney(bag[i]);
	}
private void appendMoney(Money m) {
	if (fMonies.isEmpty()) {
			fMonies.add(m);
	} else {
		int i = 0;
		while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
			i++;
		if (i >= fMonies.size()) {
			fMonies.add(m);
		} else {
			fMonies.set(i, new Money(fMonies.get(i).amount() +
					m.amount(),m.currency()));
		}
	}
	}

public MoneyBag add(Money m) {
    Money[] bag = new Money[fMonies.size() + 1];
    fMonies.copyInto(bag);
    bag[bag.length - 1] = m;
    return new MoneyBag(bag);
}

public MoneyBag add(MoneyBag mb) {
    Money[] bag1 = new Money[fMonies.size()];
    fMonies.copyInto(bag1);
    Money[] bag2 = new Money[mb.fMonies.size()];
    mb.fMonies.copyInto(bag2);
    Money[] mergedBag = new Money[bag1.length + bag2.length];
    System.arraycopy(bag1, 0, mergedBag, 0, bag1.length);
    System.arraycopy(bag2, 0, mergedBag, bag1.length, bag2.length);
    return new MoneyBag(mergedBag);
}

@Override
public boolean equals(Object obj) {
    if (this == obj)
        return true;
    if (obj == null || getClass() != obj.getClass())
        return false;
    MoneyBag other = (MoneyBag) obj;
    if (fMonies.size() != other.fMonies.size())
        return false;
    for (int i = 0; i < fMonies.size(); i++) {
        if (!fMonies.get(i).equals(other.fMonies.get(i)))
            return false;
    }
    return true;
}
}