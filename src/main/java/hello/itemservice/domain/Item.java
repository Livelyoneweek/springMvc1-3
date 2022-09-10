package hello.itemservice.domain;

import lombok.Data;

@Data
public class Item {

    private Long id;
    private String itemName;
    private Integer price; //Integer 쓴 이유는 가격이 아직 없을 수도 있어서임
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
