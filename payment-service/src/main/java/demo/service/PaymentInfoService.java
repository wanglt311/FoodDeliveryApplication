package demo.service;

import demo.domain.PaymentInfo;
import demo.domain.PaymentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
public interface PaymentInfoService {
    //PaymentInfo savePaymentInfo(PaymentInfo paymentInfo);

    List<PaymentInfo> savePaymentInfo(List<PaymentInfo> paymentInfos);

    List<PaymentInfoDto> findAll(int page, int size);

    PaymentInfo findByOrderId(String orderId);

    PaymentInfoDto findByPaymentId(Long id);

    void deleteAll();

    void deleteByOrderId(String orderId);

    PaymentStatus checkPaymentStatus(String orderId);
}
