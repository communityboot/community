package com.muchi.community.user.mapper;

import com.muchi.community.user.entity.BaseUserInterest;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author yuzq
 * @since 2019-09-14
 */
@Mapper
@Component
public interface BaseUserInterestMapper extends BaseMapper<BaseUserInterest> {

    List<Map<String,String>> getUserIdsByInterest();

    @Select("select #{ids} from information_schema.COLUMNS \n" +
            "WHERE\n" +
            "\ttable_name = 'base_user_interest' \n" +
            "\tAND table_schema = ( SELECT DATABASE ( ) ) \n" +
          "\t")
    List<String> queryIdsByInterest(String ids);

//    @Select("select #{name} from information_schema.COLUMNS \n" +
//            "WHERE\n" +
//            "\ttable_name = 'base_user_interest' \n" +
//            "\tAND table_schema = ( SELECT DATABASE ( ) ) \n" +
//            "\t")
    List<String> testParam(@Param("name") String name);
}
