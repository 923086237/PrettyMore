package com.wjt.mm.mapper.user;


import com.wjt.mm.pojo.user.UserDetail;

public interface UserDetailMapper {
    int insert(UserDetail record);

   // UserDetail selectByNo(String uno);

    int updateByPrimaryKey(UserDetail record);
}