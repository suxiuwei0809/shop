package com.myshop.dao;

 import com.shop.entity.GoodsEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsDao {

    @Select("select  * from mall_goods")
    List<GoodsEntity> queryBanner();

    @Select("select  * from mall_goods where id =#{id}")
    List<GoodsEntity> queryGoods();

    @Insert("INSERT  INTO `mall_goods`  (name,description,price,kind,picId,update_time,insert_time,sorts) VALUES (#{name}, #{description},#{price},#{kind},#{picId},#{update_time},#{insert_time},#{sorts});")
    int saveGoods(GoodsEntity  goods);

    @Update("update   `mall_goods`  set  (name,description,price,kind,picId,update_time,insert_time,sorts) VALUES (#{name}, #{description},#{price},#{kind},#{picId},#{update_time},#{insert_time},#{sorts}) where id=#{id};")
    int updateGoods(GoodsEntity  goods);

    @Delete("delete  from mall_goods where id =#{id}")
    boolean   deleteGoods(int id);
 }
