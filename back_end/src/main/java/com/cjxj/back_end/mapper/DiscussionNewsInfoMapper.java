package com.cjxj.back_end.mapper;

import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-25
 */
public interface DiscussionNewsInfoMapper extends BaseMapper<DiscussionNewsInfo> {
    /**
     * 获取讨论区的所有信息
     * @return
     */
    List<DiscussionNewsInfo> getDiscussionNewsInfo();

    /**
     * 添加讨论区的信息
     * @return
     */
    Integer addDiscussionNewsInfo(DiscussionNewsInfo discussionNewsInfo);

    /**
     * 同意添加
     * @param id
     * @return
     */
    Integer agreeDiscussionNewsInfo(String id);

    /**
     * 拒绝添加
     * @param id
     * @return
     */
    Integer rejectDiscussionNewsInfo(String id,String dealWithInformation);

    /**
     * 搜索
     * @param keyword
     * @return
     */
    List<DiscussionNewsInfo> searchDiscussionNewsInfo(String keyword);

    /**
     * 更新新闻
     * @param discussionNewsInfo
     * @return
     */
    Integer updateDiscussionNewsInfo(DiscussionNewsInfo discussionNewsInfo);

    /**
     * 获取文章信息
     * @param id
     * @return
     */
    DiscussionNewsInfo getInfoById(String id);
}
