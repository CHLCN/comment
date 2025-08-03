package com.chlcn.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 评论结果集
 */
@Data
public class CommentResultInfoDto implements Serializable {

    private Long total;

    private List<CommentDetailInfoDto> list;
}