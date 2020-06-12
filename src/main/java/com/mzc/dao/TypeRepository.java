package com.mzc.dao;

import com.mzc.po.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author mazhicheng
 * @date 2020/5/19 - 17:15
 */
public interface TypeRepository extends JpaRepository<Type,Long> {

    Type findByName(String name);

    @Query("select t from  Type t")
    List<Type> findTop(Pageable pageable);
}
