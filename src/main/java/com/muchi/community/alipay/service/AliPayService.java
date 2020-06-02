package com.muchi.community.alipay.service;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeWapPayModel;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.muchi.community.alipay.config.AlipayConfig;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description: 支付宝付款service
 * @Date: 2019/10/17   10:28
 */
@Service
public class AliPayService {

    public AlipayTradeWapPayResponse wapPay(HttpServletResponse response) throws IOException {
        AlipayClient alipayClient=new DefaultAlipayClient(AlipayConfig.URL,AlipayConfig.APPID,AlipayConfig.RSA_PRIVATE_KEY
        ,"json",AlipayConfig.CHARSET,AlipayConfig.ALIPAY_PUBLIC_KEY,AlipayConfig.SIGNTYPE);
        AlipayTradeWapPayRequest payRequest=new AlipayTradeWapPayRequest();
        AlipayTradeWapPayModel model=new AlipayTradeWapPayModel();
        model.setOutTradeNo("2019101712052221");
        model.setSubject("收费");
        model.setTotalAmount("100.0");
        model.setBody("测试");
        model.setTimeoutExpress("2m");
        model.setProductCode("QUICK_WAP_WAY");
        payRequest.setBizModel(model);
        payRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            AlipayTradeWapPayResponse alipayTradeWapPayResponse = alipayClient.pageExecute(payRequest);
            if(alipayTradeWapPayResponse.isSuccess()){
                System.out.println("调用成功！");
                return alipayTradeWapPayResponse;
            }
            else {
                System.out.println("调用错误");
                return null;
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return null;
    }

}
