package com.muchi.community.message.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.muchi.community.user.entity.User;
import com.muchi.community.message.entity.BaseMessage;
import com.muchi.community.message.mapper.BaseMessageMapper;
import com.muchi.community.message.mapper.BaseMessageRecordMapper;
import com.muchi.community.message.service.IBaseMessageService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

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
    public List<String> getMessageIds() {
        return messageMapper.getMessageIds();
    }

    /**
     * @return 查询未读公告数量
     */
    public Integer getUnReadMessageNum(){
        if(this.getUnread()!=null){
            return this.getUnread().size();
        }
        return 0;
    }

    /**
     * @return 查询未读公告列表
     */
    public List<BaseMessage> getUnreadMsg(){
        if(!Objects.requireNonNull(this.getUnread()).isEmpty()){
            List<BaseMessage> baseMessages = messageMapper.selectBatchIds(this.getUnread());
            if(baseMessages!=null){
                return baseMessages;
            }
        }
        return null;
    }

    private HashSet<String> getUnread(){
        List<String> messageIds = this.getMessageIds();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if(user !=null){
            List<String> unreadIds = recordMapper.getUnreadIds(user.getId());
            HashSet<String> h1=new HashSet<>(messageIds);
            HashSet<String> h2=new HashSet<>(unreadIds);
            h1.removeAll(h2);
            messageIds.clear();
            messageIds.addAll(h1);
            return h1;
        }
        return null;
    }

    /**
     * @param id 公告id
     * @return id为该公告的详情
     */
    public BaseMessage getUnreadMsgDetail(Integer id) {
        if (id != null && id > 0) {
            return messageMapper.selectById(id);
        }
        return new BaseMessage();
    }
}
