package market.api.model;

public class OrderInputDto {
    private Delivery delivery;
    private Integer itemPriceId;
    private Integer quantity;

    public OrderInputDto(Delivery delivery, Integer itemPriceId, Integer quantity) {
        this.delivery = delivery;
        this.itemPriceId = itemPriceId;
        this.quantity = quantity;
    }

    public OrderInputDto() {
    }
}

