package demo.domain;

import demo.domain.PaymentInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {

    Page<PaymentInfo> findAll(Pageable pageable);

    PaymentInfo findByOrderId(@Param("orderId") String orderId);

//    Page<PaymentInfo> findByUserName(@Param("userName") String userName,
//                                     Pageable pageable);

    PaymentInfo findById(@Param("paymentId") Long id);

    void deleteAll();

    void deleteByOrderId(@Param("orderId") String orderId);
}
