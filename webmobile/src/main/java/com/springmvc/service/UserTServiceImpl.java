package com.springmvc.service;

import com.springmvc.dao.IUserTDao;
import com.springmvc.mapper.UserTMapper;
import com.springmvc.pojo.UserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tangminghui on 2017/10/10.
 */
@Service
public class UserTServiceImpl implements IUserTService {

    @Autowired
    private UserTMapper userTMapper;

    public void add(UserT userT) {
        userTMapper.insert(userT);
    }

    public List<UserT> getUsers(int index) {
        return userTMapper.selectByIndex(index * 10);
    }


}
