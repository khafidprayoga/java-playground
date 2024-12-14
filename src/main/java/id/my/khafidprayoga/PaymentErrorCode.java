package id.my.khafidprayoga;

public enum PaymentErrorCode {
    SETTLEMENT_ERROR("settlement error"),
    BALANCE_INSUFFICIENT("balance insufficient"),
    GAS_FEES_REQUIRED("not enough gas fees");
    private final String code;

    PaymentErrorCode(String code) {
        this.code = code;
    }

    public String toString() {
        return code.toUpperCase();
    }
}
