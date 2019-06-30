package cn.cyf.user.controller;

import cn.cyf.common.ResponseData;
import cn.cyf.user.form.LoginForm;
import cn.cyf.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("auth")
    public ResponseData login(@RequestBody @Valid LoginForm form, BindingResult result) {

        return loginService.authLogin(form);
//        return ResponseData.ok();
    }

    /**
     * 查询当前登录用户的信息
     */
    @PostMapping("/getInfo")
    public ResponseData getInfo() {
        return loginService.getInfo();
    }

    /**
     * 登出
     */
    @PostMapping("/logout")
    public ResponseData logout() {
        return loginService.logout();
    }
}
