package com.muchi.community;

import com.muchi.community.common.validate.Person;
import com.muchi.community.common.validate.ValidationResult;
import com.muchi.community.common.validate.ValidationUtil;
import org.junit.Test;

import java.util.Map;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/10/3   21:51
 */

public class DictNotNullTest {

 @Test
  public void testVo(){
      Person person=new Person();
      person.setAge(53);
      person.setCity("sss");
      person.setName("");
      ValidationResult validationResult = ValidationUtil.validateEntity(person);
      Map<String, String> errorMsg = validationResult.getErrorMsg();
      boolean hasErrors = validationResult.isHasErrors();
      System.out.println("isError: "+hasErrors);
      System.out.println(errorMsg);
  }

}
