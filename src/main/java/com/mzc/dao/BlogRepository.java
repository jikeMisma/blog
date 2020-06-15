package com.mzc.dao;

import com.mzc.po.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/5/20 - 19:14
 */

//JpaSpecificationExecutor帮助实现组合动态的查询
public interface BlogRepository extends JpaRepository<Blog,Long>, JpaSpecificationExecutor<Blog> {

    @Query("select b from  Blog b where b.recommened = true ")
    List<Blog> findTop(Pageable pageable);

    @Query("select b from Blog  b where  b.title like ?1 or b.content like ?1")
    Page<Blog> findByQuery(String query, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Blog b set b.views=b.views+1 where b.id = ?1")
    int updateViews(Long id);
}
