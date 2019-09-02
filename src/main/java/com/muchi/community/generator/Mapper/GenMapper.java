package com.muchi.community.generator.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.muchi.community.generator.entity.FieledComment;
import com.muchi.community.generator.entity.TableInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/2   15:29
 */
@Mapper
@Component
public interface GenMapper extends BaseMapper<FieledComment> {


    @Select("SELECT\n" +
            "\ttable_name tableName,\n" +
            "\ttable_comment tableComment\n" +
            "FROM\n" +
            "\tinformation_schema.TABLES \n" +
            "WHERE\n" +
            "\ttable_schema = ( SELECT DATABASE ( ) )")
    List<TableInfo> getAllTable();



    @Select("SELECT\n" +
            "\tcolumn_name columnName,\n" +
            "\tcolumn_comment columnComment\n" +
            "FROM\n" +
            "\tinformation_schema.COLUMNS \n" +
            "WHERE\n" +
            "\ttable_name = #{table_name} \n" +
            "\tAND table_schema = ( SELECT DATABASE ( ) ) ")
    List<FieledComment> getAllField(@Param("table_name")String table_name);

}
