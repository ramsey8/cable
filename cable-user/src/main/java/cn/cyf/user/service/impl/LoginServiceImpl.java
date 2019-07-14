package cn.cyf.user.service.impl;

import cn.cyf.common.Constants;
import cn.cyf.common.ErrorCodeEnum;
import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.form.LoginForm;
import cn.cyf.user.mapper.UserMapper;
import cn.cyf.user.result.UserInfoResult;
import cn.cyf.user.service.LoginService;
import cn.cyf.user.service.PermissionService;
import cn.cyf.user.service.UserInfoService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.google.common.collect.Maps;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import static cn.cyf.common.Constants.SESSION_USER_INFO;


@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, UserInfo> implements LoginService {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private UserInfoService userInfoService;

    @Override
    public ResponseData authLogin(LoginForm form) {

        Subject curUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(form.getUsername(), form.getPassword());
        try {
            curUser.login(token);
            UserInfo userInfo = (UserInfo) (SecurityUtils.getSubject().getSession().getAttribute(SESSION_USER_INFO));
            userInfo.setLastLoginTime(new Date());
            userInfoService.updateById(userInfo);
            return ResponseData.ok();
        } catch (LockedAccountException ex) {
            return ResponseData.fail(ErrorCodeEnum.C00000006);
        } catch (AuthenticationException ex) {
            return ResponseData.fail(ErrorCodeEnum.C00000004);
        }
    }

    /**
     * 根据用户名和密码查询对应的用户
     */
    @Override
    public UserInfo getUser(String username) {
        Map<String, Object> queryMap = Maps.newHashMap();
        queryMap.put("username", username);
        List<UserInfo> userInfos = baseMapper.selectByMap(queryMap);
        if (CollectionUtils.isEmpty(userInfos)) {
            return null;
        }
        return userInfos.get(0);
    }

    /**
     * 查询当前登录用户的权限等信息
     */
    @Override
    public ResponseData getInfo() {
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        UserInfo userInfo = (UserInfo) session.getAttribute(SESSION_USER_INFO);
        String username = userInfo.getUsername();
        UserInfo userPermission = permissionService.getUserPermission(username);
        session.setAttribute(Constants.SESSION_USER_PERMISSION, userPermission);

        UserInfoResult result = new UserInfoResult();
        BeanUtils.copyProperties(userPermission, result);
        return ResponseData.ok(result);
    }

    /**
     * 退出登录
     */
    @Override
    public ResponseData logout() {
        try {
            Subject currentUser = SecurityUtils.getSubject();
            currentUser.logout();
        } catch (Exception e) {
        }
        return ResponseData.ok();
    }
}
