package com.myshop.dao;

import com.shop.entity.GoodsEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsDao {

    @Select("select  * from mall_goods")
    List<GoodsEntity> queryBanner();

    @Select("select  * from mall_goods where id =#{id}")
    List<GoodsEntity> queryGoods();

    @Insert("INSERT  INTO `mall_goods`  (name,description,price,kind,picId,update_time,insert_time,sorts) VALUES (#{name}, #{description},#{price},#{kind},#{picId},#{update_time},#{insert_time},#{sorts});")
    int saveGoods(Map map);

    @Update("update   `mall_goods`  set  (name,description,price,kind,picId,update_time,insert_time,sorts) VALUES (#{name}, #{description},#{price},#{kind},#{picId},#{update_time},#{insert_time},#{sorts}) where id=#{id};")
    int updateGoods(Map map);

    @Delete("delete  from mall_goods where id =#{id}")
    boolean deleteGoods(int id);
}
