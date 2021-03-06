package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * Created by vagrant on 6/24/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
public class DeliveryInfo {
    @Id
    private Long id;
    private String orderId;
    private String userName;
    private String deliveryAddress;
    private String phoneNum;

    public DeliveryInfo() {

    }

    @JsonCreator
    public DeliveryInfo(@JsonProperty("orderId") String orderId,
                        @JsonProperty("firstName") String userName,
                        @JsonProperty("deliveryAddress") String deliveryAddress,
                        @JsonProperty("phoneNum") String phoneNum) {
        this.orderId = orderId;
        this.userName = userName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNum = phoneNum;
    }
}
