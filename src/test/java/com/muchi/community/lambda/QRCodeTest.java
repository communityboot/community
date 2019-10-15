package com.muchi.community.lambda;

import com.muchi.community.common.utils.QRCodeUtil;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/10/15   9:53
 */
public class QRCodeTest {

    public static void main(String[] args) {
        try {
            QRCodeUtil.encode("http://39.106.121.52:8088/community/index", "mzlogo.png","mzsq.jpg");
            System.out.println("生成成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
