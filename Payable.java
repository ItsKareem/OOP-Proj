public interface Payable {

    enum PaymentMethod{
        CASH, CREDIT_CARD, ONLINE
    }

    void processPayment(double amount, PaymentMethod method);

    boolean isPaid();

}