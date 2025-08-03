package com.chlcn.entity;

import lombok.Data;

import java.util.Date;

@Data
public class CommentEntity {

    private Long id;
    private Long userId;
    private Integer module;
    private Long resourceId;
    private String content;
    private Integer status;
    private Integer score;
    private Integer starNum;
    private Integer isDelete;
    private Date createTime;
    private Date updateTime;
}
