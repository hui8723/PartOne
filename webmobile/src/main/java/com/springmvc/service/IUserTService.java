package com.springmvc.service;

import com.springmvc.pojo.UserT;

import java.util.List;

/**
 * Created by tangminghui on 2017/10/10.
 */
public interface IUserTService {
    public void add(UserT userT);

    List<UserT> getUsers(int index);
}
