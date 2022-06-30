package com.cjxj.back_end.service;

import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-25
 */
public interface IDiscussionNewsInfoService extends IService<DiscussionNewsInfo> {
    /**
     * 获取讨论区的所有信息
     * @return
     */
    List<DiscussionNewsInfo> getDiscussionNewsInfo();

    /**
     * 添加讨论区的信息
     * @param discussionNewsInfo
     * @return
     */
    Integer addDiscussionNewsInfo(DiscussionNewsInfo discussionNewsInfo);
}
