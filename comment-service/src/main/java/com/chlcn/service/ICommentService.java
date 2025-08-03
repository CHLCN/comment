package com.chlcn.service;

import com.chlcn.dto.CommentInfoDto;
import com.chlcn.dto.CommentResultInfoDto;

public interface ICommentService {
    int addComment(CommentInfoDto dto);

    int deleteComment(CommentInfoDto dto);

    CommentResultInfoDto queryCommentByParam(CommentInfoDto dto);
}
