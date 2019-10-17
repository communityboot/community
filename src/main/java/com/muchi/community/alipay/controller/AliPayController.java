package com.muchi.community.alipay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.alipay.api.response.AlipayTradeWapPayResponse;
import com.muchi.community.alipay.config.AlipayConfig;
import com.muchi.community.alipay.service.AliPayService;
import com.muchi.community.common.utils.MzResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Author： yuzq
 * @Description: 支付宝付款控制器
 * @Date: 2019/10/17   10:27
 */
@Controller
@RequestMapping("/aliPay")
public class AliPayController {

    @Autowired
    private AliPayService aliPayService;

    @RequestMapping("/aliWapPay")
    public void aliWapPay(HttpServletResponse response) throws IOException {
        AlipayTradeWapPayResponse re = aliPayService.wapPay(response);
        if (re != null) {
            String form = re.getBody();
            System.out.println(form);
            response.setContentType("text/html;charset=" + AlipayConfig.CHARSET);
            response.getWriter().write(form);
            response.getWriter().flush();
            response.getWriter().close();
            System.out.println(re.getMerchantOrderNo()+"---"+re.getOutTradeNo()+"===="+re.getSellerId()+"===="+re.getTotalAmount());
        }
    }

    @PostMapping("/aliNotify")
    public String aliNotify(HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> params = new HashMap<>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
            /*try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "GBK");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }*/
            params.put(name, valueStr);
            System.out.println(params);
            boolean signVerify = false;
            try {
                signVerify = AlipaySignature.rsaCertCheckV1(params, AlipayConfig.ALIPAY_PUBLIC_KEY, AlipayConfig.CHARSET, AlipayConfig.SIGNTYPE);
            } catch (AlipayApiException e) {
                System.out.println("回调失败 e" + e + "===params是" + params);
                e.printStackTrace();
                return "fail";
            }
            if (!signVerify) {
                return "fail";
            }
            BigDecimal trade_price = new BigDecimal(request.getParameter("total_amount"));
            //商户订单号
            String out_trade_no = params.get("out_trade_no");
            //支付宝交易号
            String trade_no = params.get("trade_no");
            //交易状态
            String trade_status = params.get("trade_status");
            // 支付成功修改订单状态
            if (trade_status.equals("TRADE_FINISHED") || trade_status.equals("TRADE_SUCCESS")) {
                System.out.println("成功！");
                //业务处理，主要是更新订单状态
            }
        } return "success";
    }
}