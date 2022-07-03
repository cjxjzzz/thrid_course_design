package com.cjxj.back_end.service;

import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-30
 */
public interface IUserService extends IService<User> {
    User getUserInfo(String openId);

    /**
     * 更改信息
     * @param user
     * @return
     */
    Integer updateUser(User user);
}
