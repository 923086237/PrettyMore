package com.wjt.mm.com.vo;

import java.io.Serializable;

/**
 * @author Barrior丶
 * @date 2018/10/23 22:33
 */
public class R implements Serializable {
    private int code;
    private String msg;
    private Object obj;

    public R(int code, String msg, Object o) {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public R(){}
}
