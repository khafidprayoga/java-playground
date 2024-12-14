package id.my.khafidprayoga;

public class PaymentError extends RuntimeException {
    private final PaymentErrorCode code;

    public PaymentError(PaymentErrorCode errCode, String message) {
        super(message);

        this.code = errCode;
    }

    public String toString() {
        return String.format("got error with message %s, and error code %s", this.getMessage(), this.code.toString());
    }
}
