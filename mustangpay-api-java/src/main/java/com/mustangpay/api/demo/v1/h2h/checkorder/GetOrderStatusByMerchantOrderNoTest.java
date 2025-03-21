package com.mustangpay.api.demo.v1.h2h.checkorder;

import com.mustangpay.api.constants.MustangpayApiConstantsV1;
import com.mustangpay.api.enums.OperationEnum;
import com.mustangpay.api.pojo.MerchantOrderStatusReq;
import com.mustangpay.api.utils.mustangpay.MustangpayApiUtilsV1;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * @Author: hyssop
 * @Date: 08/28/2024
 */
@Slf4j
public class GetOrderStatusByMerchantOrderNoTest {
    public static void main(String[] args) throws Exception {
        MerchantOrderStatusReq req = new MerchantOrderStatusReq();
        req.setMerchantId(MustangpayApiConstantsV1.merchantId);
        //First, execute PreOrderTest to obtain the reference field.
        req.setMerchantOrderNo("a3470b0d-436b-443e-8ebf-997e7a46150a");
        Map<String, Object> result =  MustangpayApiUtilsV1.callTest("GetOrderStatusByMerchantOrderNoTest", req, OperationEnum.CHECKORDER.getCode());
        log.info("GetOrderStatusByMerchantOrderNoTest result ->{}", result);
    }
}
