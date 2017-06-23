package demo.rest;

import demo.domain.PaymentInfo;
import demo.service.PaymentInfoDto;
import demo.service.PaymentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by vagrant on 6/22/17.
 */
@RestController
public class PaymentInfoController {

    private PaymentInfoService paymentInfoService;

    @Autowired
    public PaymentInfoController(PaymentInfoService paymentInfoService) {
        this.paymentInfoService = paymentInfoService;
    }

    @RequestMapping(value = "/paymentinfos", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestBody List<PaymentInfo> paymentInfos) {
        this.paymentInfoService.savePaymentInfo(paymentInfos);
    }

    @RequestMapping(value = "/paymentinfos", method = RequestMethod.GET)
    public List<PaymentInfoDto> findAll(@RequestParam(value = "page") int page,
                                        @RequestParam(value = "size") int size) {
        return this.paymentInfoService.findAll(page, size);
    }

    @RequestMapping(value = "/paymentinfos/{paymentId}", method = RequestMethod.GET)
    public PaymentInfoDto findByPaymentId(@PathVariable("paymentId") Long paymentId) {
        return this.paymentInfoService.findByPaymentId(paymentId);
    }

    @RequestMapping(value = "/paymentinfos/{orderId}", method = RequestMethod.GET)
    public PaymentInfo findByOrderId(@PathVariable("orderId") String orderId) {
        return this.paymentInfoService.findByOrderId(orderId);
    }

    @RequestMapping(value = "/paymentinfos/purge", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void purge() {
        this.paymentInfoService.deleteAll();
    }

    @RequestMapping(value = "/paymentinfos/{orderId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteByOrderId(@PathVariable("orderId") String orderId) {
        this.paymentInfoService.deleteByOrderId(orderId);
    }
}
