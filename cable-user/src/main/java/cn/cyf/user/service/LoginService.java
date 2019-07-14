package cn.cyf.user.service;

import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.form.LoginForm;
import com.baomidou.mybatisplus.service.IService;

public interface LoginService extends IService<UserInfo> {
    UserInfo getUser(String loginName);

    ResponseData authLogin(LoginForm form);

    ResponseData getInfo();

    ResponseData logout();

}
