package com.muchi.community;

import com.muchi.community.common.service.MailService;
import com.muchi.community.generator.entity.FieledComment;
import com.muchi.community.generator.entity.TableInfo;
import com.muchi.community.generator.service.GenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/2   16:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GenTest {

    @Autowired
    private GenService genService;

    @Autowired
    private MailService mailService;

    @Test
    public void testGen(){
        List<FieledComment> admin = genService.getTableInfo("admin");
        genService.genTableInfo(admin);
    }

    @Test
    public void testGenForm(){
        List<FieledComment> admin = genService.getTableInfo("sys_user");
        genService.genCrudPage(admin);
    }

    @Test
    public void testTable(){
        List<TableInfo> tableInfos = genService.genTable();
    }

    @Test
    public void testMail(){
        mailService.sendMail("1065265077@qq.com");
    }
}
