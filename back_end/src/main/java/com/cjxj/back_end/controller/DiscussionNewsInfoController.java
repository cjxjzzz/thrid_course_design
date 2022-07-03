package com.cjxj.back_end.controller;


import com.cjxj.back_end.entity.DiscussionNewsInfo;
import com.cjxj.back_end.entity.Result;
import com.cjxj.back_end.service.IDiscussionNewsInfoService;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
     *
     * @param discussionNewsInfo
     * @return
     */
    @PostMapping("/addInfo")
    public Result addDiscussionNewsInfo(@RequestBody DiscussionNewsInfo discussionNewsInfo) {
        String id = discussionNewsInfoService.addDiscussionNewsInfo(discussionNewsInfo);
        Result result = new Result();
        result.setCode(200);
        result.setData(id);
        return result;
    }

    /**
     * 图片上传的功能
     *
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile file, HttpServletRequest request) {
        Result result = new Result();
//        Map<String, Object> result = new HashMap<>();
        // 图片上传过来的名称
        String originalFilename = file.getOriginalFilename();
//        if (!(originalFilename.endsWith(".jpg") || originalFilename.endsWith(".png"))) {
//            result.setData("error type");
//            result.setCode(400);
//            return result;
//        }
        // 根据文件的类型不同存入不同的文件夹中
        String type = "";
        if ((originalFilename.endsWith(".jpg") || originalFilename.endsWith(".png"))) {
            type = "images";
        } else {
            type = "video";
        }

        // 保存文件的路径
        String url = System.getProperty("user.dir") + "\\" + type + "\\";
        File folder = new File(url);
        if (!folder.exists()) {
            folder.mkdir();
        }
        String newName = UUID.randomUUID().toString().replaceAll("-", "") + originalFilename;
        try {
            file.transferTo(new File(folder, newName));
            // 生成的文件名称
            newName = "/" + type + "/" + newName;
            String urlName = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + newName;
            result.setData(urlName);
            result.setCode(200);
        } catch (IOException e) {
            result.setData(e.getMessage());
            result.setCode(400);
        }
        return result;
    }

    /**
     * 搜索功能
     *
     * @return
     */
    @PostMapping("/search")
    public Result searchDiscussionNewsInfo(String keyword) {
        System.out.println("keyword:" + keyword);
        Result result = new Result();
        List<DiscussionNewsInfo> discussionNewsInfo = discussionNewsInfoService.searchDiscussionNewsInfo(keyword);
        result.setCode(200);
        result.setData(discussionNewsInfo);
        return result;
    }

    /**
     * 同意添加
     *
     * @param id
     * @return
     */
    @PostMapping("agreeInfo")
    public Result agreeDiscussionNewsInfo(String id) {
        Result result = new Result();
        Integer integer = discussionNewsInfoService.agreeDiscussionNewsInfo(id);
        if (integer > 0) {
            result.setCode(200);
            result.setData("同意成功");
        } else {
            result.setCode(400);
            result.setData("error");
        }
        return result;
    }

    /**
     * 不同意添加
     *
     * @param id
     * @param dealWithInformation
     * @return
     */
    @PostMapping("/rejectInfo")
    public Result rejectDiscussionNewsInfo(String id, String dealWithInformation) {
        Result result = new Result();
        Integer integer = discussionNewsInfoService.rejectDiscussionNewsInfo(id, dealWithInformation);
        if (integer > 0) {
            result.setCode(200);
            result.setData("拒绝成功");
        } else {
            result.setCode(400);
            result.setData("error");
        }
        return result;
    }

    /**
     * 更新新闻
     *
     * @param discussionNewsInfo
     * @return
     */
    @PostMapping("updateInfo")
    public Result updateDiscussionNewsInfo(@RequestBody DiscussionNewsInfo discussionNewsInfo) {
        Result result = new Result();
        Integer integer = discussionNewsInfoService.updateDiscussionNewsInfo(discussionNewsInfo);
        if (integer > 0) {
            result.setCode(200);
            result.setData("修改成功");
        } else {
            result.setCode(400);
            result.setData("error");
        }
        return result;
    }

}
