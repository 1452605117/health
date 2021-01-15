package com.alibaba.health.dao;

import com.alibaba.health.pojo.CheckGroup;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void addCheckGroupCheckItem(@Param("checkGroupId") Integer checkGroupId, @Param("checkitemId") Integer checkitemId);

    Page<CheckGroup> findByCondition(String queryString);

    CheckGroup findById(int id);

    List<Integer> findCheckItemIdsByCheckGroupId(int id);

    void update(CheckGroup checkgroup);


    void deleteCheckGroupCheckItem(Integer id);

    int findSetmealCountByCheckGroupId(int id);

    void deleteById(int id);

    List<CheckGroup> findAll();
}
