package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.criterion.Order;
import org.springframework.core.Ordered;

import javax.persistence.Embeddable;

/**
 * Created by vagrant on 6/22/17.
 */
@Embeddable
@Data
public class OrderedItem {
    private String itemName;
    private int itemQuant;
    private double itemPrice;

    public OrderedItem() {

    }

    @JsonCreator
    public OrderedItem(@JsonProperty("itemName") String itemName,
                       @JsonProperty("itemQuant") int itemQuant,
                       @JsonProperty("itemPrice") double itemPrice) {
        this.itemName = itemName;
        this.itemQuant = itemQuant;
        this.itemPrice = itemPrice;
    }

}
