package com.wjt.mm.service.sso;

import com.wjt.mm.com.vo.R;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Barrior丶
 * @date 2018/10/24 22:51
 */
public interface SSOService {
    R login(String phone, String password, HttpServletResponse response);

    R checkLogin(String token);

    R loginOut(String token,HttpServletResponse response);
}
