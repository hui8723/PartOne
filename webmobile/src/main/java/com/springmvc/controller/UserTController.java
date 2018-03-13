package com.springmvc.controller;

import com.springmvc.entity.ResponseEntity;
import com.springmvc.mapper.UserTMapper;
import com.springmvc.pojo.UserT;
import com.springmvc.service.IUserTService;
import com.springmvc.service.UserTServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
 import  com.springmvc.dao.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangminghui on 2017/10/10.
 */
@Controller
@RequestMapping("/User")
public class UserTController {

    @Autowired
    private IUserTService iUser;

//    public Log log = LogFactory.getLog(UserTController.class);


    @RequestMapping(value = "/add",method = RequestMethod.POST,produces = "application/json")
    public @ResponseBody ResponseEntity addUser(@RequestBody UserT userT) {
        ResponseEntity responseEntity = new ResponseEntity();
//        UserTServiceImpl iUser = new UserTServiceImpl();
        try {
            iUser.add(userT);
            responseEntity.setCode("0");
            responseEntity.setMessage("新增用户成功。");
        }catch (Exception e) {
            responseEntity.setCode("1");
            responseEntity.setMessage("新增用户失败。");
            e.printStackTrace();
        }
        return responseEntity;
    }

    /**
     * 分页获取用户数据，每页最多十个
     * @param index
     * @return
     */
    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody List<UserT> getUsers(int index) {
        List<UserT> userTList = new ArrayList<UserT>();
        try {
           userTList = iUser.getUsers(index);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return userTList;
    }

}
