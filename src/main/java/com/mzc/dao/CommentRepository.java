package com.mzc.dao;

import com.mzc.po.comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/6/15 - 9:26
 */
public interface CommentRepository extends JpaRepository<comment,Long> {

    List<comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
