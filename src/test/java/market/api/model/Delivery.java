package market.api.model;

public class Delivery {
    private Address address;
    private String courierType;
    private String deliveryDate;
    private Gift gift;
    private Price price;

    public Delivery() {
    }

    public Delivery(Address address, String courierType, String deliveryDate, Gift gift, Price price) {
        this.address = address;
        this.courierType = courierType;
        this.deliveryDate = deliveryDate;
        this.gift = gift;
        this.price = price;
    }
}
