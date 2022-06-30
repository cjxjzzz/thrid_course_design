package com.cjxj.back_end.controller;


import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.entity.Result;
import com.cjxj.back_end.service.IDiscussionNewsInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

import static com.cjxj.back_end.util.UUIDUtil.getUUID;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-25
 */
@RestController
@RequestMapping("/discussionNewsInfo")
public class DiscussionNewsInfoController {
    @Resource
    IDiscussionNewsInfoService discussionNewsInfoService;

    /**
     * 获取讨论区新闻信息
     *
     * @return
     */
    @RequestMapping("/getInfo")
    public Result getDiscussionNewsInfo() {
        List<DiscussionNewsInfo> discussionNewsInfo = discussionNewsInfoService.getDiscussionNewsInfo();
        Result result = new Result();
        result.setData(discussionNewsInfo);
        result.setCode(200);
        return result;
    }

    /**
     * 添加讨论区新闻
     * @param discussionNewsInfo
     * @return
     */
    @PostMapping("/addInfo")
    public Result addDiscussionNewsInfo(@RequestBody DiscussionNewsInfo discussionNewsInfo) {
        Integer integer = discussionNewsInfoService.addDiscussionNewsInfo(discussionNewsInfo);
        Result result = new Result();
        if(integer == 1){
            result.setCode(200);
            result.setData(integer);
        }else{
            result.setCode(400);
            result.setData(integer);
        }
        return result;
    }

    public Result searchDiscussionNewsInfo(){
        return null;
    }

}
