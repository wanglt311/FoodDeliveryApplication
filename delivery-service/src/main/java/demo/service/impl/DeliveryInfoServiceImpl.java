package demo.service.impl;

import demo.domain.DeliveryInfo;
import demo.domain.DeliveryInfoRepository;
import demo.service.DeliveryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
@Service
public class DeliveryInfoServiceImpl implements DeliveryInfoService {
    private DeliveryInfoRepository deliveryInfoRepository;

    @Autowired
    DeliveryInfoServiceImpl(DeliveryInfoRepository deliveryInfoRepository) {
        this.deliveryInfoRepository = deliveryInfoRepository;
    }

    @Override
    public List<DeliveryInfo> save(List<DeliveryInfo> deliveryInfos) {
        List<DeliveryInfo> deliveryInfoList = new ArrayList<DeliveryInfo>();
        for (DeliveryInfo deliveryInfo : deliveryInfos) {
            deliveryInfoList.add(deliveryInfo);
        }
        return deliveryInfoList;
    }

    @Override
    public List<DeliveryInfo> findAll() {
        return deliveryInfoRepository.findAll();
    }

    @Override
    public DeliveryInfo findByUserName(String userName) {
        return deliveryInfoRepository.findByUserName(userName);
    }
}
