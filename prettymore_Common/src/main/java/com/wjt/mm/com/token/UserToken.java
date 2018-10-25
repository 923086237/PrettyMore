package com.wjt.mm.com.token;

/**
 * @author Barrior丶
 * @date 2018/10/24 14:51
 */
public class UserToken {
    private long time;
    private Object user;
    private int randomnum;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Object getUser() {
        return user;
    }

    public void setUser(Object user) {
        this.user = user;
    }

    public int getRandomnum() {
        return randomnum;
    }

    public void setRandomnum(int randomnum) {
        this.randomnum = randomnum;
    }
}
