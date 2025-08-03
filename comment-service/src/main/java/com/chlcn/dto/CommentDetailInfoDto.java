package com.chlcn.dto;

//import com.chlcn.param.ReplyInfoDto;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 评论的dto
 */
@Data
public class CommentDetailInfoDto implements Serializable {

    /**
     * 评论ID
     */
    private Long id;

    /**
     * 父评论ID
     * 一般用于多级回复时需要
     */
    private Long parentCommentId;
    /**
     * 根评论ID
     * 一般用于多级回复时需要
     */
    private Long rootCommentId;

    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 被回复的用户名
     */
    private String repliedUsername;

    /**
     * 模块
     */
    private Integer module;
    /**
     * 资源id
     */
    private Long resourceId;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 评分
     */
    private Integer score;
    /**
     * 点赞数
     */
    private Integer starNum;
    /**
     * 是否点赞
     */
    private Boolean hasStar;
    /**
     * 是否删除
     *
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

//    private List<ReplyInfoDto> replyList;
    /**
     * 回复数量
     */
    private Integer replyCount;

    private Integer hotScore;
}

