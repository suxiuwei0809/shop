package com.myshop.service;

import com.myshop.dao.GoodsDao;
import com.shop.api.GoodsService;
import com.shop.base.BaseController;
import com.shop.base.ResponseBase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


@CrossOrigin
@RestController
public class GoodsServiceImpl extends BaseController implements GoodsService {

    @Autowired
    GoodsDao goodsDao;

    @Override
    public ResponseBase queryBanner() {

        return setResultSuccess(goodsDao.queryBanner());
    }

    @Override
    public ResponseBase queryGoods() {
        return setResultSuccess(goodsDao.queryGoods());
    }

    @Override
    public ResponseBase saveGoods(HttpServletRequest request) {
        Map map = getRequestParamMap(request);
        return setResultSuccess(goodsDao.saveGoods(map));
    }

    @Override
    public ResponseBase updateGoods(HttpServletRequest request) {
        Map map = getRequestParamMap(request);
        return setResultSuccess(goodsDao.updateGoods(map));
    }

    @Override
    public ResponseBase deleteGoods(int id) {
        return setResultSuccess(goodsDao.deleteGoods(id));
    }
}
