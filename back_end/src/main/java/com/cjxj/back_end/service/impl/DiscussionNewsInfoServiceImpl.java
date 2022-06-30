package com.cjxj.back_end.service.impl;

import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.mapper.DiscussionNewsInfoMapper;
import com.cjxj.back_end.service.IDiscussionNewsInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.cjxj.back_end.util.UUIDUtil.getUUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-25
 */
@Service
public class DiscussionNewsInfoServiceImpl extends ServiceImpl<DiscussionNewsInfoMapper, DiscussionNewsInfo> implements IDiscussionNewsInfoService {
    @Resource
    private DiscussionNewsInfoMapper discussionNewsInfoMapper;

    /**
     * 获取讨论区的所有信息
     * @return
     */
    @Override
    public List<DiscussionNewsInfo> getDiscussionNewsInfo() {
        return discussionNewsInfoMapper.getDiscussionNewsInfo();
    }

    /**
     * 添加讨论区的信息
     * @param discussionNewsInfo
     * @return
     */
    @Override
    public Integer addDiscussionNewsInfo(DiscussionNewsInfo discussionNewsInfo) {
        // 设置随机id
        discussionNewsInfo.setId(getUUID());
        // 设置状态
        discussionNewsInfo.setStatus("审核中");
        // 设置默认的点赞和收藏
        discussionNewsInfo.setLikes("[]");
        discussionNewsInfo.setCollects("[]");
        // 设置上传的时间
        discussionNewsInfo.setPubDate(LocalDateTime.now());
        System.out.println(discussionNewsInfo);
        Integer integer = discussionNewsInfoMapper.addDiscussionNewsInfo(discussionNewsInfo);
        return integer;
    }
}
