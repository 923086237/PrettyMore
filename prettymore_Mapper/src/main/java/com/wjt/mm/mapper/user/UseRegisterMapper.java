package com.wjt.mm.mapper.user;


import com.wjt.mm.pojo.user.UseRegister;

public interface UseRegisterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UseRegister record);

    int insertSelective(UseRegister record);

    UseRegister selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UseRegister record);

    int updateByPrimaryKey(UseRegister record);
}