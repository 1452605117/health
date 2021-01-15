package com.alibaba.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;

import com.alibaba.health.constant.MessageConstant;
import com.alibaba.health.entity.Result;
import com.alibaba.health.pojo.OrderSetting;
import com.alibaba.health.utils.POIUtils;
import com.alibaba.service.OrderSettingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



@RestController
@RequestMapping("/ordersetting")
public class OrderSettingController {

    private static final Logger log = LoggerFactory.getLogger(OrderSettingController.class);

    @Reference
    private OrderSettingService orderSettingService;


    @PostMapping("/upload")
    public Result upload(MultipartFile excelFile){
        //解析excel文件，调用POIUitls解析文件，得到List<String[]> ，
        // 每一个数组就代表着一行记录
        try {
            List<String[]> excelData = POIUtils.readExcel(excelFile);
            log.debug("导入预约设置读取到了{}条记录",excelData.size());
            //转成List<Ordersetting>，再调用service 方法做导入，返回给页面
            // String[] 长度为2, 0:日期，1：数量
            final SimpleDateFormat sdf = new SimpleDateFormat(POIUtils.DATE_FORMAT);
            List<OrderSetting> orderSettingList = excelData.stream().map(arr -> {
                OrderSetting os = new OrderSetting();
                try {
                    os.setOrderDate(sdf.parse(arr[0]));
                    os.setNumber(Integer.valueOf(arr[1]));
                } catch (ParseException e) {
                }
                return os;
            }).collect(Collectors.toList());
            // 调用服务导入
            orderSettingService.addBatch(orderSettingList);
            return new Result(true, MessageConstant.IMPORT_ORDERSETTING_SUCCESS);
        } catch (IOException e) {
            log.error("导入预约设置失败",e);
            return new Result(false, MessageConstant.IMPORT_ORDERSETTING_FAIL);
        }
    }


    @GetMapping("/getOrderSettingByMonth")
    public Result getOrderSettingByMonth(String month){
        // 按月查询预约设置信息
        List<Map<String,Integer>> data = orderSettingService.getOrderSettingByMonth(month);
        return new Result(true, MessageConstant.GET_ORDERSETTING_SUCCESS,data);
    }


    @PostMapping("/editNumberByDate")
    public Result editNumberByDate(@RequestBody OrderSetting orderSetting){
        // 调用服务更新
        orderSettingService.editNumberByDate(orderSetting);
        return new Result(true, MessageConstant.ORDERSETTING_SUCCESS);
    }
}
