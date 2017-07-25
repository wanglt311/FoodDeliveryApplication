package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.Id;
import java.util.Date;


/**
 * Created by vagrant on 6/22/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Table(name = "PAYMENTINFO")
@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    private CreditCardInfo creditCardInfo;
    private double totalAmount;
    private Date timestamp;
    private String orderId;
    private String userName;
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    public PaymentInfo() {
        this.creditCardInfo = null;
    }

    public PaymentInfo(CreditCardInfo creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public PaymentInfo(String firstName, String lastName, Long cardNum, int expirationMonth,
                       int expirationYear, int securityCode) {
        this.creditCardInfo = new CreditCardInfo(firstName, lastName, cardNum, expirationMonth,
                expirationYear, securityCode);
    }

    @JsonCreator
    public PaymentInfo(@JsonProperty("orderId") String orderId,
                       @JsonProperty("totalAmount") double totalAmount,
                       @JsonProperty("userName") String userName,
                       @JsonProperty("creditCardInfo") CreditCardInfo creditCardInfo) {
        this.orderId = orderId;
        this.totalAmount = totalAmount;
        this.userName = userName;
        this.creditCardInfo = creditCardInfo;
        this.timestamp = new Date();
    }
}
