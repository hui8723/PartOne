package com.springmvc.dao;

import com.springmvc.mapper.UserTMapper;
import com.springmvc.pojo.UserT;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangminghui on 2017/10/11.
 */
public class IUserImpl implements  IUserTDao {

    @Autowired
    private UserTMapper userTMapper;

    public void add(UserT userT) {
       userTMapper.insert(userT);
    }
}
