package com.alibaba.service;

import com.alibaba.health.entity.PageResult;
import com.alibaba.health.entity.QueryPageBean;
import com.alibaba.health.exception.MyException;
import com.alibaba.health.pojo.Setmeal;

import java.util.List;

public interface SetmealService {
    void add(Setmeal setmeal, Integer[] checkgroupIds);

    PageResult<Setmeal> findPage(QueryPageBean queryPageBean);

    Setmeal findById(int id);

    List<Integer> findCheckGroupIdsBySetmealId(int id);

    void update(Setmeal setmeal, Integer[] checkgroupIds);

    void deleteById(Integer id) throws MyException;;

    List<String> findImgs();

    List<Setmeal> findAll();

}
