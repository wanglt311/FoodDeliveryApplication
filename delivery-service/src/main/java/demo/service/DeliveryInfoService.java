package demo.service;

import demo.domain.DeliveryInfo;

import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
public interface DeliveryInfoService {
    List<DeliveryInfo> save(List<DeliveryInfo> deliveryInfos);

    List<DeliveryInfo> findAll();

    DeliveryInfo findByFristNameAndLastName(String firstname, String lastName);
}
