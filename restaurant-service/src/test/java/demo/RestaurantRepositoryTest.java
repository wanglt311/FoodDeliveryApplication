package demo;

import demo.domain.RestaurantServiceApplication;
import demo.domain.domain.MenuInfo;
import demo.domain.domain.RestaurantInfo;
import demo.domain.domain.RestaurantRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by vagrant on 6/25/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RestaurantServiceApplication.class)
@WebAppConfiguration
public class RestaurantRepositoryTest {
    @Autowired
    RestaurantRepository restaurantRepository;

    @Test
    public void saveRestaurant() {
        List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();
        menuInfos.add(new MenuInfo("menutest_1"));
        menuInfos.add(new MenuInfo("menutest_2"));
        this.restaurantRepository.save(new RestaurantInfo("liting rest", "7th hoboken",
                38.9856, -39.6657, menuInfos));
//        assertEquals(this.restaurantRepository.findByRestaurantName("liting rest"),
//                this.restaurantRepository.save(new RestaurantInfo("liting rest", "7th hoboken",
//                        38.9856, -39.6657, menuInfos)));
        //assertEquals(true, this.restaurantRepository.findByRestaurantName("liting rest").getRestaurantName().isEqualsTo("liting rest");
    }

    @Test
    public void queryByRestaurantName() {
        List<MenuInfo> menuInfos = new ArrayList<MenuInfo>();
        menuInfos.add(new MenuInfo("menutest_12"));
        menuInfos.add(new MenuInfo("menutest_22"));
        this.restaurantRepository.save(new RestaurantInfo("liting rest2", "7th hoboken",
                38.9856, -39.6657, menuInfos));
        String restaurantNameTest = this.restaurantRepository.findByRestaurantName("liting rest2").getRestaurantName();
        assert restaurantNameTest == "liting rest2" : "names do not match";
        //assertTrue(this.restaurantRepository.findAllByRestaurantName("liting rest2").getTotalElements() == 1);
//        assertTrue(this.restaurantRepository.findAllByRestaurantName("liting rest2").getContent().get(0)
//        .getRestaurantName().equals("liting rest2"));
    }
}
