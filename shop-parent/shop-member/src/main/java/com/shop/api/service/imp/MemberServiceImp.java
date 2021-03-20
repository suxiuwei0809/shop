package com.shop.api.service.imp;

import com.alibaba.fastjson.JSONObject;
import com.shop.api.MemberService;
import com.shop.base.BaseApiService;
import com.shop.base.BaseRedisService;
import com.shop.base.ResponseBase;
import com.shop.dao.MemberDao;
import com.shop.entity.UserEntity;
import com.shop.mq.SendEmailBoxProdcer;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
public class MemberServiceImp extends BaseApiService implements MemberService {

    @Autowired
    private MemberDao memberDao;
    @Autowired
    BaseRedisService baseRedisService;
    @Autowired
    SendEmailBoxProdcer  sendEmailBoxProdcer;
    @Override
    public ResponseBase findUserById(Long userId) {
        UserEntity user = memberDao.findByID(userId);
        if (user == null) {
            return setResultError("未查找到用户信息.");
        }
        return setResultSuccess(user);
    }


    @Override
    public ResponseBase regUser(@RequestBody UserEntity user) {

        user.getPassword();
        String  email=user.getEmail();
        String  e = converJsonString(email);

        //log.info("生产者开始发送到队列"+e);
        sendMsg(e);
        //log.info("生产者开始发送到队列完成");
   //     memberDao.insertUser(user);

        return setResultSuccess();
    }


    private  String  converJsonString(String  email){
        JSONObject rootObject =  new  JSONObject();
        JSONObject header =  new  JSONObject();
        JSONObject content =  new  JSONObject();
        header.put("interfaceType","email");
        content.put("email",email);
        rootObject.put("header",header);
        rootObject.put("content",content);
        return rootObject.toJSONString();
    }

    private void  sendMsg(String  json){
        //新建一个为队列名称为messages_queue的队列
        ActiveMQQueue   activeMQQueue    =new ActiveMQQueue("messages_email_queue");

        sendEmailBoxProdcer.SendMsg(activeMQQueue,json);
    }


}
