package com.muchi.community.alipay.config;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/10/17   10:26
 */
public class AlipayConfig {

    // 商户appid
    public static String APPID = "2016100100638435";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDFvMoBsiz1G1d9hlTo/Rqcmy18en3v62Q0+wGDFbwvqgagauGYsy/f9VHt28o4EKGecLfw/vYxdWlKZsSJFilNhEtbb09f8u0ODkMVjHgPgTrz0v27sykb1zmGuUbKmvHN829+QzaQ3AakDcz0b/wWHpWu1SPQezHGXCxKZFUvSE5UXWdbX278tfcesTr0NGVg7Ycdd8RF7UuLZZuWXpLkZAVgcuW7LcerKd7ZumhTkEbpqhqLieufzmY/9KnnOBxhs8COPAchdt6wEd4odXXJif5p13oFAAruORk77bBS104apZ0DpUFx/09iqOX2KjB8QS5CsrNXNzjhA3xR+VHdAgMBAAECggEAS56qRkHEjav6JogD2uJIlhGGMK+LkAAeX2CKsH3UbQoB5MFbKxGDwotH3MYMLKq3lCcZQTHQJxP2wzxP9vkhrIJmaz5DRbdaTuDHaOtCUvOh/vL2lBytIPeLCWm7l+nvhUqOnePIb1eltoGMmwJkjnT921Gpk6Y5X9mKGp0KMr0wT8DwKyoP/Z6uw+8WH8BVl8h5hRNdRP0nHOpidkvyk/Sv3E84O1tRtxPt1vkMUilkY5mm3JOJ9zO9EaxA98qkSB3AQU2DQ5A2Y9l72lJmZsZ/O7I/XMEkPmZGuJdD9kiccZsm6Dc1b+RUsjLd8A/++I5NF46zfJDLkT7Z5lBSRQKBgQD3j/NmQONsoqd/8KC+CR9S93Qmw9QQ1tMu58zBGSgs3SN1MmWoEUMFxQa7eDWPuqJSoyhNPFZPJBVZhHTOGvysahcw/EWf9wuAMBAhGSIGjPvoi7UkN+M6lv9nLO92TsQh0HfnuBmDOrXDTXYfmGLVJVxGbmBlAnXfDfCcluOqCwKBgQDMehpQPhQowrmxhxfpw1q4LZO3QfbHueLxkJfuKj+CzYn2+erVbnmAP3RSbcb1wcd97EDgHIuFFcb/6MlDDaNYpopoAoFvB6fJdo9U5ZZ+dDlJWxcpAF9uZp+HzbQjDxHeTTn9nldrPpfFr5Ine/Zp3mIv5HZPkHRqbBl4i27MtwKBgQCrFoT0KewCa/auaLHuI4fOYs2W7MdmS9DvHatX1/b36mxS1l2C5UsYda3Naao6hpUf3zo/Bm/vidRnZS8EMYpl7XvRksbbYnRERvMerKvjMxP1BnhNa4JSP4CK4XcsoArUA6qaLZUUKELtkl8MPtguzf8TfbyIkka7vHqI/Y6hOQKBgHTsQU2vIdHo/0wPZtIp/h8hGL2Kv7WXirj9KJNsnyKJq6GJaQoggOOf5UEZOtLeutc7mCFO0U0JleBR2Xw5OTWBDdXJ0P+PThd6bx1ppzOp+/QBXW35o5g6oHCEZMRDYsFOQaHPwEc35IuLCLUBQndpTZX7OtfmT1tncu0mNfZjAoGAL83HJnd/i0rr29JAZeLNPdPRSmdxiPx28IR0jCS+4umNnRt1oUqt3GwMMy4x6t1weJ3Azo/+CxfsGO5Jp1zhFHpsDuH6nzdGsxHx+DokR7TI7g9TEdCo2t5SyFTY1DIGTjMKvzT7D8UzIiew4hEvdxsymPsjYQrq2K0C06CoO2c=";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost/alipay.trade.wap.pay-JAVA-UTF-8/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = "http://商户网关地址/alipay.trade.wap.pay-JAVA-UTF-8/return_url.jsp";
    // 请求网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAipjk//8CmfXq46qTDYRKQiO1nJVOnnKuj8TfWypvveL6YAYKacusynay7lhl/pW9H3N/tWw7qZ6AFn0lXz+2CbJh4O1SlqBav9uikWW/Ku5VQBijenHTd6dYZEGpGuxAiiet27Al9fBneawCqfFmJe+7OqjvfEq37Sn+/h0DXsWrjGCNHMgcupRlcIfjDAyQdnEkhcUicYPCVFp58S2pCqBR5BmeQbIzwCq5Lb1X6Tshawt3TpLPN4Z9RU8c5YLJxDBAPNu192FV2ZQE14qQphDp2oMnN9AYrOq79whspHoLinfFvbWqi4tBR1I7ibMIcIQI1mqJHQwVvLGZd113RwIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";
}
