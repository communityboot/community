package com.muchi.web;

import com.muchi.entity.Dict;
import com.muchi.service.DictService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/7/30   10:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class AddDictTest {

    @Autowired
    private DictService dictService;

    @Test
    public void test(){
        for(int i=0;i<100;i++){
            Dict dict=new Dict();
            dict.setDictName("字典"+i);
            dict.setId("000"+i);
            dict.setDictLabel("dict"+i);
            dict.setEnabled(1);
            dictService.save(dict);
        }

    }
}
