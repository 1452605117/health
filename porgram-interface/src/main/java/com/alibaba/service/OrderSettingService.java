package com.alibaba.service;

import com.alibaba.health.exception.MyException;
import com.alibaba.health.pojo.OrderSetting;

import java.util.List;
import java.util.Map;

public interface OrderSettingService {



    List<Map<String, Integer>> getOrderSettingByMonth(String month);

    void editNumberByDate(OrderSetting orderSetting) throws MyException;

    void addBatch(List<OrderSetting> orderSettingList);
}
