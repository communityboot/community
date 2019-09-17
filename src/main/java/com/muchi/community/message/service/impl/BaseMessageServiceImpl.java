package com.muchi.community.message.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.muchi.community.common.utils.MzResult;
import com.muchi.community.dict.entity.BaseDict;
import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.mapper.BaseMessageMapper;
import com.muchi.community.message.mapper.BaseMessageRecordMapper;
import com.muchi.community.message.service.IBaseMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.community.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author yuzq
 * @since 2019-09-07
 */
@Service
public class BaseMessageServiceImpl extends ServiceImpl<BaseMessageMapper, BaseMessage> implements IBaseMessageService {

    @Autowired
    private BaseMessageMapper messageMapper;

    @Autowired
    private BaseMessageRecordMapper recordMapper;


    /**
     * @param page 分页参数
     * @return 分页后的数据
     */
    @Override
    public List<BaseMessage> getAllDict(Page page) {
        return messageMapper.getAllMessage(page);
    }

    /**
     * @return 公告表所有的id
     */
    @Override
    public List<Integer> getMessageIds() {
        return messageMapper.getMessageIds();
    }

    public Integer getUnReadMessageNum(){
        List<Integer> messageIds = this.getMessageIds();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user !=null){
            //对已读的记录进行去重
            List<Integer> unreadIds = recordMapper.getUnreadIds(Integer.parseInt(user.getId()));
            HashSet<Integer> h1=new HashSet<>(messageIds);
            HashSet<Integer> h2=new HashSet<>(unreadIds);
            h1.removeAll(h2);
            messageIds.clear();
            messageIds.addAll(h1);
            Map<String ,Object> map=new HashMap<>();
//            map.put("unReadNum",h1.size());
//            map.put("unReadIds",h1);
            return h1.size();
        }
        return 0;
    }
}
