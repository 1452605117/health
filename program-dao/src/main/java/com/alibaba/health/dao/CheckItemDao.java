package com.alibaba.health.dao;

import com.alibaba.health.pojo.CheckItem;
import com.github.pagehelper.Page;

import java.util.List;

public interface CheckItemDao {
  List<CheckItem> findAll();

  void add(CheckItem checkItem);

    Page<CheckItem> findByCondition(String queryString);

  CheckItem findById(int id);

  void update(CheckItem checkItem);

  int findCountByCheckItemId(int id);

  void deleteById(int id);
}
