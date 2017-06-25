package demo.domain.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by vagrant on 6/20/17.
 */
@Table(name = "RESMENUS")
@Data
@Entity
public class MenuInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String menuId;
    private String foodName;
    private double foodPrice;

    //private Long restaurantId;
    private String restaurantName;

    @ManyToOne(targetEntity = RestaurantInfo.class, cascade = CascadeType.ALL)
    private RestaurantInfo restaurantInfo;

    public MenuInfo() {

    }

    @JsonCreator
    public MenuInfo(@JsonProperty("menuId") String menuId) {
        this.menuId = menuId;
    }

    @JsonCreator
    public MenuInfo(@JsonProperty("menuId") String menuId,
                    @JsonProperty("foodName") String foodName,
                    @JsonProperty("foodPrice") double foodPrice,
                    @JsonProperty("restaurantName") String restaurantName) {
        this.menuId = menuId;
        this.foodName = foodName;
        this.foodPrice = foodPrice;
        this.restaurantInfo.setRestaurantName(restaurantName);
    }
}
