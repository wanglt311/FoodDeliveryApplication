package demo.domain;

import demo.domain.DeliveryInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by vagrant on 6/24/17.
 */
//how a repository is defined, configure the path
    //deliveryinfos/search/deliverys
@RepositoryRestResource(path = "deliveryinfos")
public interface DeliveryInfoRepository extends Repository<DeliveryInfo, Long> {
    //@RestResource(path = "deliveries",rel = "deliverys")
    List<DeliveryInfo> findAll();

    @RestResource(path = "deliveries", rel = "deliveries")
    DeliveryInfo findByUserName(@Param("firstName") String userName);

}
