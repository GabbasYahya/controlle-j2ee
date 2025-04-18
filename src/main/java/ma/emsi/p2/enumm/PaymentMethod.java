package ma.emsi.p2.enumm;



public enum PaymentMethod {
    CREDIT_CARD("Carte de crédit"),
    PAYPAL("PayPal"),
    BANK_TRANSFER("Virement bancaire"),
    MOBILE_MONEY("Mobile Money"),
    CRYPTO("Cryptomonnaie"),
    OTHER("Autre");

    private final String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}