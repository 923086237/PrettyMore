package com.wjt.mm.service.user;

import com.wjt.mm.com.qo.QueryParam;
import com.wjt.mm.com.vo.R;
import com.wjt.mm.pojo.user.User;

/**
 * @author Barrior丶
 * @date 2018/10/24 21:42
 */
public interface UserService {
    //新增
    R register(User user);

    //忘记密码
    R forgetPass(QueryParam<String> param);

    //修改密码
    R updatePass(String phone, String password);

    //登录
    User login(String phone, String password);
}
