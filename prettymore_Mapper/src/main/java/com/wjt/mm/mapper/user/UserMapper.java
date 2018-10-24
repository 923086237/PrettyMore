package com.wjt.mm.mapper.user;


import com.wjt.mm.com.qo.QueryParam;
import com.wjt.mm.pojo.user.User;

public interface UserMapper {

    int insert(User record);

    //修改密码
    int updatePassword(QueryParam<String> param);

    //查询
    User selectPhone(String phone);
}