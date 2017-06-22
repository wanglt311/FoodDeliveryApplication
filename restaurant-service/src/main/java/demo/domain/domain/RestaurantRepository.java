package demo.domain.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vagrant on 6/20/17.
 */
public interface RestaurantRepository extends JpaRepository<RestaurantInfo, Long> {
    //find all restaurant
    Page<RestaurantInfo> findAll(Pageable pageable);

    //return search result restaurant by name
    RestaurantInfo findByRestaurantName(@Param("restaurant_name") String restaurantName);

    //return search result restaurant by location
    RestaurantInfo findByLocation(@Param("location") Point location);

    //find restaurant by id
    List<MenuInfo> findAllByRestaurantName(String restaurantName);

    //delete restaurant info by id
    void deleteById(@Param("id") Long id);
}
