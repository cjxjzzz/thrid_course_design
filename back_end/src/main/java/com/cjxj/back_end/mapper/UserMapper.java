package com.cjxj.back_end.mapper;

import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-30
 */
public interface UserMapper extends BaseMapper<User> {
    User getUserInfo(String openId);

    Integer addUser(User user);

    /**
     * 更改信息
     * @param user
     * @return
     */
    Integer updateUser(User user);

}
