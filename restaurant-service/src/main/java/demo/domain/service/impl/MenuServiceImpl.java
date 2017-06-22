package demo.domain.service.impl;

import demo.domain.domain.MenuInfo;
import demo.domain.domain.MenuRepository;
import demo.domain.domain.RestaurantRepository;
import demo.domain.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/21/17.
 */
@Service
public class MenuServiceImpl implements MenuService{

    private RestaurantRepository restaurantRepository;
    private MenuRepository menuRepository;

    @Autowired
    public MenuServiceImpl(RestaurantRepository restaurantRepository,
                                 MenuRepository menuRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuRepository = menuRepository;
    }

    @Override
    public List<MenuInfo> saveMenu(List<MenuInfo> menuInfos) {
        return menuRepository.save(menuInfos);
    }

    @Override
    public Page<MenuInfo> findAll(Pageable pageable) {
        return menuRepository.findAll(pageable);
    }

    @Override
    public MenuInfo findByMenuId(String menuId) {
        return menuRepository.findByMenuId(menuId);
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
    public MenuInfo findByFoodName(String foodName) {
        return menuRepository.findByFoodName(foodName);
    }
}
