package market.api.model;

public class Price {
    private String currency;
    private Integer value;

    public Price(String currency, Integer value) {
        this.currency = currency;
        this.value = value;
    }

    public Price() {
    }
}
