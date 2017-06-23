package demo.service.impl;

import demo.domain.PaymentInfo;
import demo.domain.PaymentInfoRepository;
import demo.service.PaymentInfoDto;
import demo.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
@Service
public class PaymentInfoServiceImpl implements PaymentInfoService{
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    public PaymentInfoServiceImpl(PaymentInfoRepository paymentInfoRepository) {
        this.paymentInfoRepository = paymentInfoRepository;
    }


//    @Override
//    public PaymentInfo savePaymentInfo(PaymentInfo paymentInfo) {
//        return paymentInfoRepository.save(paymentInfo);
//    }

    @Override
    public List<PaymentInfo> savePaymentInfo(List<PaymentInfo> paymentInfos) {
        return paymentInfoRepository.save(paymentInfos);
    }

    @Override
    public List<PaymentInfoDto> findAll(int page, int size) {
        Pageable pageable = new PageRequest(page, size);
        return convertToPaymentInfoDto(this.paymentInfoRepository.findAll(pageable));
    }

    private List<PaymentInfoDto> convertToPaymentInfoDto(Page<PaymentInfo> paymentInfos) {
        List<PaymentInfo> paymentInfoList = paymentInfos.getContent();
        List<PaymentInfoDto> paymentInfoDtos = new ArrayList<PaymentInfoDto>();
        for (PaymentInfo paymentInfo : paymentInfoList) {
            paymentInfoDtos.add(new PaymentInfoDto(paymentInfo));
        }

        return paymentInfoDtos;
    }

    @Override
    public PaymentInfo findByOrderId(String orderId) {
        return paymentInfoRepository.findByOrderId(orderId);
    }

    @Override
    public PaymentInfoDto findByPaymentId(Long paymentId) {
        PaymentInfo paymentInfo = this.paymentInfoRepository.findById(paymentId);
        if (paymentInfo == null) {
            return null;
        }
        return new PaymentInfoDto(paymentInfo);
    }

    @Override
    public void deleteAll() {
        this.paymentInfoRepository.deleteAll();
    }

    @Override
    public void deleteByOrderId(String orderId) {
        this.paymentInfoRepository.deleteByOrderId(orderId);
    }
}
