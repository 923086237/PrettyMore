package com.wjt.mm.com.utils;

import com.wjt.mm.com.vo.R;

/**
 * @author Barrior丶
 * @date 2018/10/23 22:35
 */
public class RUtils {
    public static R setOK(String msg){
        return new R(200,msg,null);
    }

    public static R setError(String msg){
        return new R(400,msg,null);
    }

    public static R getR(int count){
        if(count>0){
            return new R(200,"操作成功",null);
        }else{
            return new R(400,"操作失败",null);
        }
    }
    public static R getR(int code,String msg,Object obj){
        return new R(code,msg,obj);
    }


}
