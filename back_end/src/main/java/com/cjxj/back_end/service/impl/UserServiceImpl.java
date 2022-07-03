package com.cjxj.back_end.service.impl;

import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.entity.User;
import com.cjxj.back_end.mapper.UserMapper;
import com.cjxj.back_end.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cjxj.back_end.util.UUIDUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User getUserInfo(String openId) {
        // 首先获取用户的信息
        User userInfo = userMapper.getUserInfo(openId);
//        System.out.println(userInfo);
        if(userInfo == null){
            // 数据库中没有这个用户 添加一个新的这个用户
            User user = new User();
            user.setId(UUIDUtil.getUUID());
            user.setOpenId(openId);
            user.setPrivilege("user");
            user.setLikes("");
            user.setCollects("");
            user.setFulfilledNews("");
            user.setPendingNews("");
            Integer integer = userMapper.addUser(user);
            // 重新获取数据返回
            if(integer == 1){
                userInfo = userMapper.getUserInfo(openId);
            }
        }
        return userInfo;
    }

    /**
     * 更改信息
     * @param user
     * @return
     */
    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

}
