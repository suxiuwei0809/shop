package com.myshop.dao;

import com.shop.entity.MenusEntity;
import com.shop.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface MenusDao {

    @Select(" select  *  from  mall_menus")
    List<Map> getMenus();


    @Insert("INSERT  INTO mall_menus  ( name, parentid, path, sorts, module, isback)" +
            " VALUES (#{name}, #{parentid},#{path},#{sorts},#{module},#{isback});")
    Integer insertMenu(Map map);



    @Delete("delete  from mall_menus  where  id=#{id}")
    void deleteMenu(int  id);
}
