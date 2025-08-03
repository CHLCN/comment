package com.chlcn.param;

import lombok.Data;

@Data
public class DelCommentRequestParam {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 评论id
     */
    private String commentId;
    /**
     * 模块
     * 0：社区模块
     * 1：游戏模块
     * 2：短视频模块
     */
    private Integer module;
    /**
     * 资源id
     */
    private String resourceId;

}
