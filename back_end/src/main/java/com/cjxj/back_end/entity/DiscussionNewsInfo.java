package com.cjxj.back_end.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author cjxjzzz
 * @since 2022-06-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("discussion_news_info")
@ApiModel(value="DiscussionNewsInfo对象", description="")
public class DiscussionNewsInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("title")
    private String title;

    @TableField("pub_date")
    private LocalDateTime pubDate;

    @TableField("description")
    private String description;

    @TableField("creator")
    private String creator;

    @TableField("image_urls")
    private String imageUrls;

    @TableField("video_urls")
    private String videoUrls;

    @TableField("likes")
    private String likes;

    @TableField("collects")
    private String collects;

    @TableField("status")
    private String status;

    @TableField("deal_with_information")
    private String dealWithInformation;
}
