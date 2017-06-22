package demo.domain.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vagrant on 6/21/17.
 */
public interface MenuRepository extends JpaRepository<MenuInfo, Long> {
    //find all menus
    Page<MenuInfo> findAll(Pageable pageable);

    //return search result menu by restaurant name
    List<MenuInfo> findAllByRestaurantName(@Param("restaurant_name") String restaurantName);

    //return search result menu by menuId
    MenuInfo findByMenuId(@Param("menu_Id") String menuId);

    //find menu by foodName
    MenuInfo findByFoodName(@Param("food_name") String foodName);

}
