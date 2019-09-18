package com.muchi.community.generator.service;

import com.muchi.community.generator.Mapper.GenMapper;
import com.muchi.community.generator.entity.FieledComment;
import com.muchi.community.generator.entity.TableInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2019/9/2   15:46
 */
@Service
public class GenService {

    @Autowired
    private GenMapper genMapper;

    /**
     * 生成表单
     */
    public List<TableInfo> genTable(){
       return genMapper.getAllTable();
    }

    public List<FieledComment> getTableInfo(String tableName){
        return genMapper.getAllField(tableName);
    }

    public void genTableInfo(List<FieledComment> fieledComments){
        StringBuilder sb=new StringBuilder();
/*        String prefix = "layui.use('table', function () {\n" +
                "        var table = layui.table;\n" +
                "        table.render({\n" +
                "            elem: '#dict'\n" +
                "            , url: '/dict/getAll'\n" +
                "            , toolbar: '#toolbarDemo'\n" +
                "            , title: '字典表'\n" +
                "            , page: true\n" +
                "            ,even: true\n" +
                "            ,cellMinWidth: 30 //全局定义常规单元格的最小宽度，layui 2.2.1 新增\n" +
                "            , cols: [[\n" +
                "                {type: 'checkbox', fixed: 'left'}";
        sb.append(prefix);*/
        for(int i=0;i<fieledComments.size();i++){
            sb.append(", {field: '").append(fieledComments.get(i).getField()).append("', title: '").append(fieledComments.get(i).getTitle()).append("', width: 80}");
        }
        sb.append("     ]]\n" +
                "        });");
        System.out.println(sb.toString());

    }
}
