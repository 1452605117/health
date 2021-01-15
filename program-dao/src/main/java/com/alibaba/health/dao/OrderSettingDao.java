package com.alibaba.health.dao;

import com.alibaba.health.pojo.OrderSetting;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface OrderSettingDao {

    OrderSetting findByOrderDate(Date orderDate);


    void add(OrderSetting os);

    void updateNumber(OrderSetting os);


    List<Map<String, Integer>> getOrderSettingByMonth(String month);
}
