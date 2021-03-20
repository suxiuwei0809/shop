package com.myshop.service;

import com.myshop.dao.GoodsDao;
import com.shop.api.GoodsService;
import com.shop.base.BaseController;
import com.shop.base.ResponseBase;

import com.shop.entity.GoodsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

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
        public ResponseBase saveGoods(GoodsEntity goods) {
            return setResultSuccess( goodsDao.saveGoods(goods));
        }

        @Override
        public ResponseBase updateGoods(GoodsEntity goods) {
            return setResultSuccess( goodsDao.updateGoods(goods));
        }

        @Override
        public ResponseBase deleteGoods(int id) {
            return    setResultSuccess(goodsDao.deleteGoods(id));
      }
}
