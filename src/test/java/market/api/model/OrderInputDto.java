package market.api.model;

public class OrderInputDto {
    private Delivery delivery;
    private Long itemPriceId;
    private Integer quantity;

    public OrderInputDto(Delivery delivery, Long itemPriceId, Integer quantity) {
        this.delivery = delivery;
        this.itemPriceId = itemPriceId;
        this.quantity = quantity;
    }

    public OrderInputDto() {
    }
}

