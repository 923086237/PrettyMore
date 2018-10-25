package com.wjt.mm.provider.sso;

import com.alibaba.fastjson.JSON;
import com.wjt.mm.com.token.UserToken;
import com.wjt.mm.com.utils.JedisUtil;
import com.wjt.mm.com.utils.PassUtil;
import com.wjt.mm.com.utils.RUtils;
import com.wjt.mm.com.vo.R;
import com.wjt.mm.mapper.user.UserMapper;
import com.wjt.mm.pojo.user.UseRegister;
import com.wjt.mm.pojo.user.User;
import com.wjt.mm.pojo.user.UserLog;
import com.wjt.mm.service.sso.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.Random;

/**
 * @author Barrior丶
 * @date 2018/10/24 22:57
 */
@Service
public class SSOProvider implements SSOService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private JedisUtil jedisUtil;

    @Autowired
    private UserLog userLog;

    @Autowired
    private UseRegister useRegister;

    @Override
    public R login(String phone, String password, HttpServletResponse response) {
        //1、查询数据库
        User user = userMapper.selectPhone(phone);
        //2、校验登录
        if (user != null) {
            if (Objects.equals(user.getPassword(), password)) {
                //登录成功
                //3、生成令牌
                //1、用户信息 2、时间戳 3、随机数   加密方式
                UserToken userToken = new UserToken();
                userToken.setUser(user);
                userToken.setTime(System.currentTimeMillis());
                userToken.setRandomnum(new Random().nextInt());
                String json = JSON.toJSONString(userToken);
                String token = PassUtil.base64EN(json);
                //2、存储Token 到Redis  采用Hash 键为令牌，值就是对应的用户信息
                jedisUtil.addHash("tokens", token, JSON.toJSONString(user));
                //3、存储到Cookie中  键为user 值为对应的Token
                Cookie cookie = new Cookie("mm_user", token);
                response.addCookie(cookie);
                //4、返回登录结果
                return RUtils.getR(200, "单点登录成功", user);
            }
        }
        return RUtils.setError("登录失败");
    }



    @Override
    public R checkLogin(String token) {
                //1、先校验Redis是否存在对应的令牌
                String userjson=jedisUtil.getHash("tokens",token);
                if(userjson!=null && userjson.length()>0){
                    //Token存在的
                    //2、解析令牌的对应的用户对象
                    User user=JSON.parseObject(userjson,User.class);
                    //3、反解令牌
                    UserToken userToken=JSON.parseObject(PassUtil.base64DE(token),UserToken.class);
                    //4、校验令牌中的用户信息和Redis中的用户信息是否一致
                    if(user.getNo().equals(((User)userToken.getUser()).getNo())) {
                        //5、有效
                        return RUtils.getR(200, "有效", user);
                    }
                }
                //5、无效
                return RUtils.setError("令牌失效");
    }

    @Override
    public R loginOut(String token, HttpServletResponse response) {
                //1、移除Redis数据信息
                jedisUtil.delHash("tokens",token);
                //2、将Cookie中的令牌移除
                Cookie cookie=new Cookie("mm_user",token);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                //3、记录操作日志


                return RUtils.setOK("注销成功");
    }
}
