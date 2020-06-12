package com.mzc.dao;

import com.mzc.po.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/5/19 - 17:15
 */
public interface TagRepository extends JpaRepository<Tag,Long> {

    Tag findByName(String name);

    @Query("select  t from Tag t ")
    List<Tag> findTop(Pageable pageable);

}
