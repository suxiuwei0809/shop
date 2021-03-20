package com.myshop.service;

import com.myshop.dao.MenusDao;
import com.shop.api.MenusService;
import com.shop.base.BaseController;
import com.shop.base.ResponseBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
 import java.util.Map;


@RestController
public class MenusServiceImpl extends BaseController implements MenusService {

    @Autowired
    MenusDao menusDao;

    @Override
    public ResponseBase saveMenu(HttpServletRequest request) {
        Map map =getRequestParamMap(request);
        return setResultSuccess(menusDao.insertMenu(map));
    }

    @Override
    public ResponseBase getMenus(HttpServletRequest request) {
        return setResultSuccess(menusDao.getMenus());
    }

    @Override
    public ResponseBase deleteMenu(HttpServletRequest request) {
        Map map =getRequestParamMap(request);
        menusDao.deleteMenu(Integer.parseInt(map.get("id").toString()));
        return setResultSuccess();
    }
}
