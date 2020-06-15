package com.mzc.service;

import com.mzc.po.comment;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/15 - 9:22
 */
public interface CommentsService {

    List<comment> lsitCommentByBlogId(Long blodId);

    comment saveComment(comment comment);
}
