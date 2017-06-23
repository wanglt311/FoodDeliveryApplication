package demo.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;

/**
 * Created by vagrant on 6/22/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Embeddable
public class CreditCardInfo {
    private String firstName;
    private String lastName;
    private Long cardNum;
    private int expirationMonth;
    private int expirationYear;
    private int securityCode;

    public CreditCardInfo() {

    }

    @JsonCreator
    public CreditCardInfo(@JsonProperty("firstName") String firstName,
                          @JsonProperty("lastName") String lastName,
                          @JsonProperty("cardNum") Long cardNum,
                          @JsonProperty("expirationMonth") int expirationMonth,
                          @JsonProperty("expirationYear") int expirationYear,
                          @JsonProperty("securityCode") int securityCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNum = cardNum;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.securityCode = securityCode;
    }
}
