package ss7.b2;

interface DiscountStrategy {
    public double applyDiscount(double totalAmount);
}

class PercentageDiscount implements DiscountStrategy {
    private double percent;

    public PercentageDiscount(double percent) {
        this.percent = percent;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * percent / 100);
    }
}

class FixedDiscount implements DiscountStrategy {
    private double amount;

    public FixedDiscount(double amount) {
        this.amount = amount;
    }

    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - amount;
    }
}

class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount;
    }
}

class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double totalAmount) {
        return totalAmount - (totalAmount * 15 / 100);
    }
}

class OrderCalculator {
    private DiscountStrategy discountStrategy;

    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double calculateFinalAmount(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}

public class Main {
    public static void main(String[] args) {
        double totalAmount = 1000000;

        OrderCalculator calculator1 = new OrderCalculator(new PercentageDiscount(10));
        System.out.println("So tien sau giam: " + (long) calculator1.calculateFinalAmount(totalAmount));

        OrderCalculator calculator2 = new OrderCalculator(new FixedDiscount(50000));
        System.out.println("So tien sau giam: " + (long) calculator2.calculateFinalAmount(totalAmount));

        OrderCalculator calculator3 = new OrderCalculator(new NoDiscount());
        System.out.println("So tien sau giam: " + (long) calculator3.calculateFinalAmount(totalAmount));

        OrderCalculator calculator4 = new OrderCalculator(new HolidayDiscount());
        System.out.println("So tien sau giam: " + (long) calculator4.calculateFinalAmount(totalAmount));
    }
}