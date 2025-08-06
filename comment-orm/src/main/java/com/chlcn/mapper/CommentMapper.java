package com.chlcn.mapper;

import com.chlcn.entity.CommentEntity;
import com.chlcn.entity.CommentParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    /**
     * 插入评论
     * @param entity
     * @return
     */
    int addComment(CommentEntity entity);

    /**
     * 删除评论by id
     * @return
     */
    int deleteCommentById(Long id);

    /**
     * 逻辑删除
     * @return
     */
    int updateCommentByParam(CommentParam commentParam);

    /**
     * 查询评论
     * @return
     */
    List<CommentEntity> queryCommentByParam(CommentParam commentParam);

    /**
     * 查询评论总数
     * @return
     */
    int countCommentByParam(CommentParam commentParam);
}
