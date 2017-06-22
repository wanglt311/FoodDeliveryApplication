package demo.rest;

import demo.domain.OrderInfo;
import demo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
@RestController
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    //save order infos
    @RequestMapping(value = "/orderinfos", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void update(@RequestBody List<OrderInfo> orderInfos) {
        orderInfoService.saveOrderInfo(orderInfos);
    }

    //get all order infos
    @RequestMapping(value = "/orderinfos", method = RequestMethod.GET)
    public Page<OrderInfo> getOrderInfo(@RequestParam(name = "page") int page,
                                        @RequestParam(name = "size") int size) {
        return orderInfoService.findAll(new PageRequest(page, size));
    }

    //get order info by orderId
    @RequestMapping(value = "/orderinfos/{orderId}", method = RequestMethod.GET)
    public OrderInfo findByOrderId(@PathVariable("orderId") Long orderId) {
        return orderInfoService.findByOrderId(orderId);
    }

    //delete all order infos
    @RequestMapping(value = "/orderinfos/purge", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void purge() {
        orderInfoService.deleteAll();
    }

    //delete order info by orderId
    @RequestMapping(value = "/orderinfos/{orderId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByOrderId(@RequestParam("orderId") Long orderId) {
        orderInfoService.deleteByOrderId(orderId);
    }
}
