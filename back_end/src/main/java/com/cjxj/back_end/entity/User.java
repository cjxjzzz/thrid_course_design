package com.cjxj.back_end.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-06-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("user")
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("id")
    private String id;

    @TableField("open_id")
    private String openId;

    @TableField("privilege")
    private String privilege;

    @TableField("likes")
    private String likes;

    @TableField("collects")
    private String collects;

    @TableField("pending_news")
    private String pendingNews;

    @TableField("fulfilled_news")
    private String fulfilledNews;


}
