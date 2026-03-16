package ss7.b3;

interface PaymentMethod {
}

interface CODPayable extends PaymentMethod {
    public void processCOD(double amount);
}

interface CardPayable extends PaymentMethod {
    public void processCreditCard(double amount);
}

interface EWalletPayable extends PaymentMethod {
    public void processEWallet(double amount);
}

class CODPayment implements CODPayable {
    @Override
    public void processCOD(double amount) {
        System.out.println("Xu ly thanh toan COD: " + (long) amount + " - Thanh cong");
    }
}

class CreditCardPayment implements CardPayable {
    @Override
    public void processCreditCard(double amount) {
        System.out.println("Xu ly thanh toan the tin dung: " + (long) amount + " - Thanh cong");
    }
}

class MomoPayment implements EWalletPayable {
    @Override
    public void processEWallet(double amount) {
        System.out.println("Xu ly thanh toan MoMo: " + (long) amount + " - Thanh cong");
    }
}

class PaymentProcessor implements PaymentMethod {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        if (paymentMethod instanceof CODPayable) {
            ((CODPayable) paymentMethod).processCOD(amount);
        } else if (paymentMethod instanceof CreditCardPayment) {
            ((CreditCardPayment) paymentMethod).processCreditCard(amount);
        } else if (paymentMethod instanceof EWalletPayable) {
            ((EWalletPayable) paymentMethod).processEWallet(amount);
        } else {
            System.out.println("Khong ho tro loai thanh toan nay");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor1 = new PaymentProcessor(new CODPayment());
        processor1.process(500000);
        PaymentProcessor processor2 = new PaymentProcessor(new CreditCardPayment());
        processor2.process(1000000);
        PaymentProcessor processor3 = new PaymentProcessor(new MomoPayment());
        processor3.process(750000);
        System.out.println("Kiem tra LSP:");

        PaymentMethod method;
        method = new CreditCardPayment();
        PaymentProcessor processor4 = new PaymentProcessor(method);
        processor4.process(1000000);
        method = new MomoPayment();
        processor4.setPaymentMethod(method);
        processor4.process(750000);
    }
}
