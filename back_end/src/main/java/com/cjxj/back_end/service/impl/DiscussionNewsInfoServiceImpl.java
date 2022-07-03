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
    public String addDiscussionNewsInfo(DiscussionNewsInfo discussionNewsInfo) {
        // 设置随机id
        String id = getUUID();
        discussionNewsInfo.setId(id);
        // 设置状态
        discussionNewsInfo.setStatus("审核中");
        // 设置默认的点赞和收藏
        discussionNewsInfo.setLikes("");
        discussionNewsInfo.setCollects("");
        // 设置上传的时间
        discussionNewsInfo.setPubDate(LocalDateTime.now());
        System.out.println(discussionNewsInfo);
        Integer integer = discussionNewsInfoMapper.addDiscussionNewsInfo(discussionNewsInfo);
        return id;
    }

    /**
     * 同意添加
     * @param id
     * @return
     */
    @Override
    public Integer agreeDiscussionNewsInfo(String id) {
        return discussionNewsInfoMapper.agreeDiscussionNewsInfo(id);
    }

    /**
     * 不同意添加
     * @param id
     * @param dealWithInformation
     * @return
     */
    @Override
    public Integer rejectDiscussionNewsInfo(String id, String dealWithInformation) {
        return discussionNewsInfoMapper.rejectDiscussionNewsInfo(id,dealWithInformation);
    }

    /**
     * 搜索
     * @param keyword
     * @return
     */
    @Override
    public List<DiscussionNewsInfo> searchDiscussionNewsInfo(String keyword) {
        keyword = "%"+keyword+"%";
        return discussionNewsInfoMapper.searchDiscussionNewsInfo(keyword);
    }

    /**
     * 更新新闻
     * @param discussionNewsInfo
     * @return
     */
    @Override
    public Integer updateDiscussionNewsInfo(DiscussionNewsInfo discussionNewsInfo) {
        return discussionNewsInfoMapper.updateDiscussionNewsInfo(discussionNewsInfo);
    }

    /**
     * 获取文章信息通过id
     * @param id
     * @return
     */
    @Override
    public DiscussionNewsInfo getInfoById(String id) {
        return discussionNewsInfoMapper.getInfoById(id);
    }
}
