package com.wjt.mm.controller.sso;

import com.wjt.mm.com.utils.RUtils;
import com.wjt.mm.com.vo.R;
import com.wjt.mm.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Barrior丶
 * @date 2018/10/25 9:05
 */

@RestController
public class SSOController {

    @Autowired
    private SSOService ssoService;

    //登录  可能是第一次也可能四第N次
    @PostMapping("/ssologin.do")
    public R login(HttpServletRequest request, String phone, String password, HttpServletResponse response){
        Cookie[] arrCks = request.getCookies();
        String token = "";
        if(arrCks != null){
            for (Cookie cookie : arrCks) {
                if (cookie.getName().equals("mm_user")) {
                    token = cookie.getValue();
                    break;
                }
            }

        }
        if(token.length()>0){
            //之前有过登录
            return ssoService.checkLogin(token);
        }else {
            return ssoService.login(phone,password,response);
        }
    }

    //检查是否登录
    @GetMapping("/ssocheck.do")
    public R check(HttpServletRequest request){
        Cookie[] arrCks=request.getCookies();
        String token="";
        if(arrCks!=null) {
            for (Cookie cookie : arrCks) {
                if (cookie.getName().equals("mm_user")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if(token.length()>0){
            //之前有过登录
            return ssoService.checkLogin(token);
        }else {
            return RUtils.setError("令牌失效");
        }
    }
    //注销
    @GetMapping("/ssologinout.do")
    public R loginout(HttpServletRequest request,HttpServletResponse response){
        Cookie[] arrCks=request.getCookies();
        String token="";
        if(arrCks!=null) {
            for (Cookie cookie : arrCks) {
                if (cookie.getName().equals("mm_user")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if(token.length()>0){
            return ssoService.loginOut(token,response);
        } else {
            return RUtils.setOK("注销成功");
        }
    }

}
