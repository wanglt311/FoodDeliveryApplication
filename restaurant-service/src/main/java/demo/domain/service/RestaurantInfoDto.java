package demo.domain.service;

import demo.domain.domain.MenuInfo;
import demo.domain.domain.RestaurantInfo;
import lombok.Data;

/**
 * Created by vagrant on 6/21/17.
 */
@Data
public class RestaurantInfoDto {
    private String restaurantName;
    private String restaurantAddress;
    private String menuId;
    private String foodName;
    private double foodPrice;

    public RestaurantInfoDto() {

    }

    public RestaurantInfoDto(RestaurantInfo restaurantInfo, MenuInfo menuInfo) {
        this.restaurantName = restaurantInfo.getRestaurantName();
        this.restaurantAddress = restaurantInfo.getRestaurantAddress();
        this.menuId = menuInfo.getMenuId();
        this.foodName = menuInfo.getFoodName();
        this.foodPrice = menuInfo.getFoodPrice();
    }
}
