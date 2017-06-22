package demo.domain.service;

import demo.domain.domain.MenuInfo;
import demo.domain.domain.RestaurantInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/21/17.
 */
public interface RestaurantService {

    //save Restaurant infos
    List<RestaurantInfo> saveRestaurant(List<RestaurantInfo> restaurantInfos);

    //find all restaurants
    Page<RestaurantInfo> findAll(Pageable pageable);

    //find restaurant by restaurant name
    RestaurantInfo findByRestaurantName(String restaurantName);

    //find restaurant id by restaurant name

    //create menu by restaurant name
    List<MenuInfo> createMenuInfoByRestaurantName(String restaurantName, List<MenuInfo> menuInfos);

    //get menu by restaurant name
    List<MenuInfo> findMenuByRestaurantName(String restaurantName);

    //delete all restaurant infos
    void deleteAll();

    //delete restaurant info by id
    void deleteById(Long id);
}
