package demo.service;

import demo.domain.PaymentInfo;
import lombok.Data;

import java.util.Date;
import java.util.Random;

/**
 * Created by vagrant on 6/22/17.
 */
@Data
public class PaymentInfoDto {
    private String orderId;
    private Long paymentId;
    private Date timestamp;
    private int deliveryTime;

    public PaymentInfoDto() {

    }


    public PaymentInfoDto(PaymentInfo paymentInfo) {
        this.orderId = paymentInfo.getOrderId();
        this.paymentId = paymentInfo.getId();
        this.timestamp = paymentInfo.getTimestamp();
        this.deliveryTime = generateDeliveryTime();
    }

    private int generateDeliveryTime() {
        Random random = new Random();
        return this.deliveryTime = random.nextInt(55) + 5;
    }
}
