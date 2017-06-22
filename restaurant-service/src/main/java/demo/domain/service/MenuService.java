package demo.domain.service;

import demo.domain.domain.MenuInfo;
import demo.domain.domain.RestaurantInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.awt.*;
import java.util.List;

/**
 * Created by vagrant on 6/21/17.
 */
public interface MenuService {
    //create menu
    List<MenuInfo> saveMenu(List<MenuInfo> menuInfos);

    //find all menus
    Page<MenuInfo> findAll(Pageable pageable);

    //find menu by menuId
    MenuInfo findByMenuId(String menuId);

    //create menu by restaurant name
    List<MenuInfo> createMenuInfoByRestaurantName(String restaurantName, List<MenuInfo> menuInfos);

    //get menu by restaurant name
    List<MenuInfo> findMenuByRestaurantName(String restaurantName);

    //find menu by food name
    MenuInfo findByFoodName(String foodName);
}
