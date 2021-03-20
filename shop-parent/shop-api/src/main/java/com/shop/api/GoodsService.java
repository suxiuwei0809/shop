package com.shop.api;

import com.shop.base.ResponseBase;
import com.shop.entity.GoodsEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@CrossOrigin
@RequestMapping("/goods")
public interface GoodsService {


    @RequestMapping("/queryBanner")
    ResponseBase queryBanner();

    @RequestMapping("/queryGoods")
    ResponseBase queryGoods();

    @RequestMapping("/saveGoods")
    ResponseBase saveGoods(HttpServletRequest request);

    @RequestMapping("/updateGoods")
    ResponseBase updateGoods(HttpServletRequest request);

    @RequestMapping("/deleteGoods")
    ResponseBase deleteGoods(int id);
}
