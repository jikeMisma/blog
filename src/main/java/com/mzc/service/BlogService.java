package com.mzc.service;

import com.mzc.po.Blog;
import com.mzc.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/5/20 - 18:57
 */
public interface BlogService {

    Blog getBlog(Long id);

    Blog getAndConvert(Long id) throws ClassNotFoundException;

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);

    Page<Blog> listBlog(String query, Pageable pageable);



    List<Blog> listRecommendlistBlogTop(Integer size);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog) throws ClassNotFoundException;

    void deleteBlog(Long id);
}
