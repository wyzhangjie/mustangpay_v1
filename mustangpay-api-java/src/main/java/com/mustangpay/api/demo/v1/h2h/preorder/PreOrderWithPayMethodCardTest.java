package com.mustangpay.api.demo.v1.h2h.preorder;

import com.mustangpay.api.constants.MustangpayApiConstantsV1;
import com.mustangpay.api.enums.CurrencyEnum;
import com.mustangpay.api.enums.OperationEnum;
import com.mustangpay.api.enums.PayMethodEnum;
import com.mustangpay.api.pojo.Amount;
import com.mustangpay.api.pojo.H2HCreateCashierReq;
import com.mustangpay.api.pojo.Product;
import com.mustangpay.api.utils.mustangpay.MustangpayApiUtilsV1;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @Author: hyssop
 * @Date: 08/28/2024
 */
@Slf4j
public class PreOrderWithPayMethodCardTest {
    // This method is used by the merchant to specify the payment method when invoking the checkout page. If a payMethod is provided, it indicates that the merchant only wants to use payMethod for placing orders and making payments.
// The checkout page will then navigate to a secondary page for card payment (currently only card payments are supported).
    public static void main(String[] args) throws Exception{
        // Assuming the Amount and Product classes are defined elsewhere with constructors as needed
        Amount amount = new Amount(1000L, CurrencyEnum.ZAR.getCode());
        Product product = new Product("productname", "short", "productDesc_b74f45d43c9c");

        String uniqueReference = UUID.randomUUID().toString();

        // Create CreateCashierReq object
        H2HCreateCashierReq createCashierReq = new H2HCreateCashierReq();
        createCashierReq.setMerchantName("Merchant Name");
        createCashierReq.setCountry("ZAF");
        createCashierReq.setReference(uniqueReference);
        createCashierReq.setCurrency("ZAR");
        createCashierReq.setAmount(amount);
        createCashierReq.setBusinessType("MerchantAcquiring");
        createCashierReq.setRemark("remark_83c200fa64ff");
        createCashierReq.setCallbackUrl("callbackUrl_08941d02454c");
        createCashierReq.setReturnUrl("returnUrl_86a75a09e6b8");
        createCashierReq.setCancelUrl("");
        createCashierReq.setIp("ip_2841df759b91");
        createCashierReq.setProduct(product);
        createCashierReq.setProductList(new ArrayList<>());
        createCashierReq.setExpireAt(30);
        createCashierReq.setVat(new Amount(10L, CurrencyEnum.ZAR.getCode()));
        createCashierReq.setVatNumber("vatNumber_d98853c8c10c");
        createCashierReq.setSn(""); // Assuming sn is an empty string
        createCashierReq.setMetadata(new HashMap<>());
        createCashierReq.setMerchantId(MustangpayApiConstantsV1.merchantId);
        createCashierReq.setPayMethods(Collections.singletonList(PayMethodEnum.CARD_PAYMENT.getCode()));
        createCashierReq.setCardCvv("1234");
        createCashierReq.setCardExpiryDate("122024");
        createCashierReq.setBankCardNo("4000000000000002");
      //  createCashierReq.setRemark("remark");
        Map<String, Object> result =  MustangpayApiUtilsV1.callTest("PreOrderWithPayMethodCardTest", createCashierReq, OperationEnum.H2H_PRECREATE.getCode());
        //{result={"code":"000000","data":{"cashierUrl":"http://110.238.76.97:90/pre-cashier?orderNo=F6RQPjco8t0VhyHlwIf5j3lAggrZlbniCl1ve33jDtI=","merchantId":"4449999220","orderNo":"2408281010032767517","orderStatus":"Initial","reference":"9d02a217-e5b4-4404-b2c9-df1ae8273ad5"},"msg":"ok","sign":"SpIWTc4ECRhi-Eab_yDQIi_MQQP6wn1GS7iXUahyWe5sgL8Gx0X6Kgny4gNdS4EZKugxXZcrDvWQGXau2JumKaseJ_r5UfOo1PWsG-3ceeJ1mN1s7Eau7QUYvfeScc9eIuioADmxZMtAdHwwcvdoLyZ3nENrHbs1jZ7XgWOy4OKhWmasIurjnZpGclkif4Hm1iIr_NFQVQy32bqBoTCz2MEBae5Cyeo6_a-3ZwwhyzAiFxWAEvRpDhsMRhf_HcSOgE7lDYUdcPfFUtJP9_CCojmMfLInaF0ZBEsumMybbFVaNOlayCocztjPPpsadGgegoE20jQMX4vdMNSTWOZH9A"}, code=S}
        log.info("PreOrderWithPayMethodCardTest result ->{}", result);

    }
}
