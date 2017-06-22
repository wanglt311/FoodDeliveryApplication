package demo.domain.restController;

import demo.domain.domain.MenuInfo;
import demo.domain.domain.MenuRepository;
import demo.domain.domain.RestaurantInfo;
import demo.domain.service.MenuService;
import demo.domain.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/21/17.
 */
@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private MenuService menuService;

    //save restaurant infos
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateRestaurantInfo(@RequestBody List<RestaurantInfo> restaurantInfos) {
        this.restaurantService.saveRestaurant(restaurantInfos);
    }

    //save menu infos
    @RequestMapping(value = "/menus", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void updateMenuInfo(@RequestBody List<MenuInfo> menuInfos) {
        this.menuService.saveMenu(menuInfos);
    }

    //get all restaurant infos
    @RequestMapping(value = "/restaurants", method = RequestMethod.GET)
    public Page<RestaurantInfo> getRestaurantInfo(@RequestParam(name = "page") int page,
                                                  @RequestParam(name = "size") int size) {
        return restaurantService.findAll(new PageRequest(page, size));
    }

    //get all menu infos
    @RequestMapping(value = "/menus", method = RequestMethod.GET)
    public Page<MenuInfo> getMenuInfo(@RequestParam(name = "page") int page,
                                      @RequestParam(name = "size") int size) {
        return menuService.findAll(new PageRequest(page, size));
    }

    //delete all restaurant infos
    @RequestMapping(value = "/restaurants/purge", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void purge() {
        this.restaurantService.deleteAll();
    }

    //delete restaurant by id
    @RequestMapping(value = "restaurants/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable("id") Long id) {
        this.restaurantService.deleteById(id);
    }
}
