package demo.rest;

import demo.domain.DeliveryInfo;
import demo.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/25/17.
 */
@RestController
public class DeliveryServiceController {
    private DeliveryInfoService deliveryInfoService;

    @Autowired
    public DeliveryServiceController(DeliveryInfoService deliveryInfoService) {
        this.deliveryInfoService = deliveryInfoService;
    }

    @RequestMapping(value = "/deliveryinfos", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<DeliveryInfo> deliveryInfos) {
        this.deliveryInfoService.save(deliveryInfos);
    }

    @RequestMapping(value = "/deliveryinfos", method = RequestMethod.GET)
    public List<DeliveryInfo> findAll() {
        return this.deliveryInfoService.findAll();
    }

    @RequestMapping(value = "/deliveryinfos/{firstName}/{lastName}", method = RequestMethod.GET)
    public DeliveryInfo findByFirstNameAndLastName(@PathVariable("firstName") String firstName,
                                                   @PathVariable("lastName") String lastName) {
        return this.deliveryInfoService.findByFristNameAndLastName(firstName, lastName);
    }
}
