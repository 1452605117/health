package com.alibaba.health.dao;

import com.github.pagehelper.Page;
import com.alibaba.health.pojo.Setmeal;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SetmealDao {

    void add(Setmeal setmeal);


    void addSetmealCheckGroup(@Param("setmealId") Integer setmealId, @Param("checkgroupId") Integer checkgroupId);

    Page<Setmeal> findByCondition(String queryString);


    Setmeal findById(int id);


    List<Integer> findCheckGroupIdsBySetmealId(int id);

    void update(Setmeal setmeal);


    void deleteSetmealCheckGroup(Integer id);


    int findCountBySetmealId(int id);


    void deleteById(int id);

    List<String> findImgs();
}
