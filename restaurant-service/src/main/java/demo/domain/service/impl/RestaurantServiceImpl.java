package demo.domain.service.impl;

import demo.domain.domain.MenuInfo;
import demo.domain.domain.MenuRepository;
import demo.domain.domain.RestaurantInfo;
import demo.domain.domain.RestaurantRepository;
import demo.domain.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/21/17.
 */
@Service
public class RestaurantServiceImpl implements RestaurantService {
    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository,
                                 MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<RestaurantInfo> saveRestaurant(List<RestaurantInfo> restaurantInfos) {
        return restaurantRepository.save(restaurantInfos);
    }

    @Override
    public Page<RestaurantInfo> findAll(Pageable pageable) {
        return restaurantRepository.findAll(pageable);
    }

    @Override
    public RestaurantInfo findByRestaurantName(String restaurantName) {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }

    @Override
    public List<MenuInfo> createMenuInfoByRestaurantName(String restaurantName, List<MenuInfo> menuInfos) {
        for (MenuInfo menuInfo : menuInfos) {
            menuInfo.setRestaurantName(restaurantName);
        }
        return menuRepository.save(menuInfos);
    }

    @Override
    public List<MenuInfo> findMenuByRestaurantName(String restaurantName) {
        return menuRepository.findAllByRestaurantName(restaurantName);
    }

    @Override
    public void deleteAll() {
        this.restaurantRepository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        this.restaurantRepository.deleteById(id);
    }
}
