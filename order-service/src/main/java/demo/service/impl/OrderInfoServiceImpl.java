package demo.service.impl;

import demo.domain.OrderInfo;
import demo.domain.OrderInfoRepository;
import demo.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    private OrderInfoRepository orderInfoRepository;

    @Autowired
    public OrderInfoServiceImpl(OrderInfoRepository orderInfoRepository) {
        this.orderInfoRepository = orderInfoRepository;
    }

    @Override
    public List<OrderInfo> saveOrderInfo(List<OrderInfo> orderInfos) {
        return orderInfoRepository.save(orderInfos);
    }

    @Override
    public Page<OrderInfo> findAll(Pageable pageable) {
        return orderInfoRepository.findAll(pageable);
    }

    @Override
    public OrderInfo findByOrderId(Long orderId) {
        return orderInfoRepository.findByOrderId(orderId);
    }

    @Override
    public void deleteAll() {
        this.orderInfoRepository.deleteAll();
    }

    @Override
    public void deleteByOrderId(Long orderId) {
        this.orderInfoRepository.deleteByOrderId(orderId);
    }
}
