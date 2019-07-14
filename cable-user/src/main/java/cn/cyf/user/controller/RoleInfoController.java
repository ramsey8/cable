package cn.cyf.user.controller;

import cn.cyf.common.ResponseData;
import cn.cyf.user.form.RoleInfoQueryForm;
import cn.cyf.user.form.RoleInfoUpdateForm;
import cn.cyf.user.service.PermissionService;
import cn.cyf.user.service.RoleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleInfoController {

    @Autowired
    private RoleInfoService roleInfoService;
    @Autowired
    private PermissionService permissionService;

    @GetMapping("/listRole")
    public ResponseData listRole(RoleInfoQueryForm form) {
        return ResponseData.ok(roleInfoService.selectRoleList(form));
    }

    @GetMapping("/listAllPermission")
    public ResponseData listAllPermission() {
        return ResponseData.ok(this.permissionService.listAllPermission());
    }

    @PostMapping("/updateRole")
    public ResponseData updateRole(@RequestBody RoleInfoUpdateForm form) {

        return this.roleInfoService.updateRoleInfo(form);
    }

    @PostMapping("/addRole")
    public ResponseData addRole(@RequestBody RoleInfoUpdateForm form) {
        return this.roleInfoService.addRole(form);
    }

    @PostMapping("/deleteRole")
    public ResponseData deleteRole(@RequestBody List<String> roleIdList) {
        return this.roleInfoService.deleteRole(roleIdList);
    }
}
