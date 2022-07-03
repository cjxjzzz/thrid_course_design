package com.cjxj.back_end.controller;


import com.cjxj.back_end.entity.DiscussionNewsId;
import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.entity.Result;
import com.cjxj.back_end.entity.User;
import com.cjxj.back_end.service.IDiscussionNewsInfoService;
import com.cjxj.back_end.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-30
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    IUserService userService;

    @Resource
    IDiscussionNewsInfoService discussionNewsInfoService;

    /**
     * 获取普通用户的信息
     * 如果数据库里面获取不到的话 那么就创建一个新的数据
     *
     * @param openId
     * @return
     */
    @GetMapping("/getInfo")
    public Result getUserInfo(String openId) {
        Result result = new Result();
        User userInfo = userService.getUserInfo(openId);
        result.setData(userInfo);
        result.setCode(200);
        return result;
    }

    /**
     * 更改信息
     *
     * @param user
     * @return
     */
    @PostMapping("update")
    public Result updateUser(@RequestBody User user) {
        Result result = new Result();
        Integer integer = userService.updateUser(user);
        if (integer > 0) {
            result.setCode(200);
            result.setData("修改成功");
        } else {
            result.setCode(400);
            result.setData("error");
        }
        return result;
    }

    /**
     * 获取文章信息通过id
     *
     * @return
     */
    @PostMapping("getInfoById")
    public Result getInfoById(@RequestBody DiscussionNewsId discussionNewsId) {
        String id = discussionNewsId.getId();
        Result result = new Result();
        String[] ids = id.split(",");
        List<DiscussionNewsInfo> list = new ArrayList<DiscussionNewsInfo>();
        for (int i = 0; i < ids.length; i++) {
            DiscussionNewsInfo infoById = discussionNewsInfoService.getInfoById(ids[i]);
            list.add(infoById);
        }
        result.setData(list);
        result.setCode(200);
        return result;
    }
}
