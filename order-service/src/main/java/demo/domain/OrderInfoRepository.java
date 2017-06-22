package demo.domain;

import demo.domain.OrderInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by vagrant on 6/22/17.
 */
//someday change to MongoDB
public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long>{
    Page<OrderInfo> findAll(Pageable pageable);

    OrderInfo findByOrderId(@Param("orderId") Long orderId);

    void deleteAll();

    void deleteByOrderId(@Param("orderId") Long orderId);
}
