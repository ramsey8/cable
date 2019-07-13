package cn.cyf.user.controller;

import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.RoleInfo;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.form.UserInfoQueryForm;
import cn.cyf.user.form.UserInfoUpdateForm;
import cn.cyf.user.result.UserInfoResult;
import cn.cyf.user.service.RoleInfoService;
import cn.cyf.user.service.UserInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author tony
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    private Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;
    @Autowired
    private RoleInfoService roleInfoService;

    /**
     * 查询用户列表
     * @param form
     * @return
     */
    @GetMapping("/list")
    public ResponseData listUser(UserInfoQueryForm form) {

        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(form, userInfo);
        userInfo.setDeleteStatus(1);
        Page<UserInfoResult> result = this.userInfoService.selectUserListPage(userInfo, form.getPageNum(), form.getPageRow());
        return ResponseData.ok(result);
    }

    /**
     * 查询角色列表
     * @return
     */
    @GetMapping("/getAllRoles")
    public ResponseData getAllRoles() {
        List<RoleInfo> list = roleInfoService.selectList(new EntityWrapper<RoleInfo>());
        return ResponseData.ok(list);
    }

    @PostMapping("/updateUser")
    public ResponseData updateUser(@RequestBody UserInfoUpdateForm form) {

        return this.userInfoService.updateUser(form);
    }

    @PostMapping("/addUser")
    public ResponseData addUser(@RequestBody UserInfoUpdateForm form) {

        return this.userInfoService.updateUser(form);
    }

    @PostMapping("/switch/status")
    public ResponseData switchStatus(@RequestBody UserInfoUpdateForm form) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(form, userInfo);
        userInfo.setUpdateTime(new Date());
        this.userInfoService.updateById(userInfo);
        return ResponseData.ok();
    }
}
