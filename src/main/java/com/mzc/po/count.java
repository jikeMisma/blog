package com.mzc.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mazhicheng
 * @date 2020/5/9 - 15:39
 */

@Entity
@Table(name = "t_count")
public class count {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "count{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
