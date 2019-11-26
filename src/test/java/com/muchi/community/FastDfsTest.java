/*
package com.muchi.community;

import com.muchi.community.common.utils.FastDFSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

*/
/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/10/7   9:24
 *//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class FastDfsTest {

    @Test
    public void testUpload(){
        String fileUrl=this.getClass().getResource("/IMG_105.JPG").getPath();
        System.out.println(fileUrl);
        File file=new File(fileUrl);
        String string= FastDFSClient.uploadFile(file);
        FastDFSClient.getResAccessUrl(string);
    }

    @Test
    public void testDelete(){
        FastDFSClient.deleteFile("group1/M00/00/00/wKgBvF2alTSAC5gcAAEcz00quPA995.JPG");
    }
}
*/
