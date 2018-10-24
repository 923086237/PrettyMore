package com.wjt.mm.provider.user;

import com.wjt.mm.com.qo.QueryParam;
import com.wjt.mm.com.utils.RUtils;
import com.wjt.mm.com.vo.R;
import com.wjt.mm.mapper.user.UserLogMapper;
import com.wjt.mm.mapper.user.UserMapper;
import com.wjt.mm.pojo.user.UseRegister;
import com.wjt.mm.pojo.user.User;
import com.wjt.mm.pojo.user.UserLog;
import com.wjt.mm.service.user.UserService;
import org.apache.shiro.web.servlet.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Barrior丶
 * @date 2018/10/24 9:12
 */
@Service
public class UserProvider implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserLogMapper userLogMapper;

 

    @Override
    public R register(User user) {
        // 密码加密
        userMapper.insert(user);
        UserLog log = new UserLog();
        log.setMsg("新增用户：" + user.getPhone());
        log.setType(7010);
        log.setNo(user.getNo());
        userLogMapper.insert(log);
        return RUtils.setOK("新增用户成功");
    }

    @Override
    public R forgetPass(QueryParam<String> param) {
        String phone = param.get("phone");
        String code = param.get("code");


        return RUtils.getR(userMapper.updatePassword(param));
    }

    @Override
    public R updatePass(String phone, String password) {
        QueryParam<String> param = new QueryParam<>();
        param.put("phone", phone);
        param.put("password", password);

        return RUtils.getR(userMapper.updatePassword(param));
    }

    @Override
    public User login(String phone, String password) {
        User user = userMapper.selectPhone(phone);
        if(user != null){
            if(Objects.equals(user.getPassword(),password)){
                return user;
            }
        }

        return null;
    }
}
