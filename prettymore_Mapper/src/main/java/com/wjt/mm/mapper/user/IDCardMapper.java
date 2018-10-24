package com.wjt.mm.mapper.user;


import com.wjt.mm.pojo.user.IDCard;

public interface IDCardMapper {


    int insert(IDCard record);



    IDCard selectByUno(String uno);


    int updateByPrimaryKey(IDCard record);
}