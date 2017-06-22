package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import demo.domain.OrderedItem;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Created by vagrant on 6/22/17.
 */
@Table(name = "ORDERS")
@Data
@Entity
public class OrderInfo {
    @Id
    @GeneratedValue
    private Long orderId;
    private String userName;

    @Embedded
    private List<OrderedItem> orderedItems;

    private String dietRestriction;
    private String deliveryAddress;
    private double totalPrice;
    private Date orderedTimestamp;
    private int deliveryTime;
    private Date paymentTimestamp;
    private boolean isComplete = false;

    public OrderInfo() {
        this.orderedItems = null;
    }

    @JsonCreator
    public OrderInfo(@JsonProperty("userName") String userName,
                     @JsonProperty("orderedItems") List<OrderedItem> orderedItems,
                     @JsonProperty("dietRestriction") String dietRestriction,
                     @JsonProperty("deliveryAddress") String deliveryAddress) {
        this.userName = userName;
        this.orderedItems = orderedItems;
        this.dietRestriction = dietRestriction;
        this.deliveryAddress = deliveryAddress;
        for (OrderedItem orderedItem : orderedItems) {
            this.totalPrice += orderedItem.getItemPrice();
        }
        this.orderedTimestamp = new Date();
        this.deliveryTime = generateDeliveryTime();

    }

    private int generateDeliveryTime() {
        Random random = new Random();
        return this.deliveryTime = random.nextInt(55) + 5;
    }
 }
