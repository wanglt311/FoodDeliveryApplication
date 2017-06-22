package demo.service;

import demo.domain.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
public interface OrderInfoService  {
    //save order infos
    List<OrderInfo> saveOrderInfo(List<OrderInfo> orderInfos);

    //find all order info
    Page<OrderInfo> findAll(Pageable pageable);

    //find order info by orderId
    OrderInfo findByOrderId(Long orderId);

    //delete all order info
    void deleteAll();

    //delete order info by orderId
    void deleteByOrderId(Long orderId);

}
