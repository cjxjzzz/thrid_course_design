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
}
