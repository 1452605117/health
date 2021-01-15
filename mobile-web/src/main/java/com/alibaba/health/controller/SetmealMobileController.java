package com.alibaba.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.health.constant.MessageConstant;
import com.alibaba.health.entity.Result;
import com.alibaba.health.pojo.Setmeal;
import com.alibaba.health.utils.QiNiuUtils;
import com.alibaba.service.SetmealService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/setmeal")
public class SetmealMobileController {
    @Reference
    private SetmealService setmealService;

    /**
     * 查询所有
     */
    @GetMapping("/getSetmeal")
    public Result getSetmeal(){
        // 查询所有的套餐
        List<Setmeal> list = setmealService.findAll();
        // 套餐里有图片有全路径吗? 拼接全路径
        list.forEach(s->s.setImg(QiNiuUtils.DOMAIN+s.getImg()));
        return new Result(true, MessageConstant.GET_SETMEAL_LIST_SUCCESS,list);
    }
}
