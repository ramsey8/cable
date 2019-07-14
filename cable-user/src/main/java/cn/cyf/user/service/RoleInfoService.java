package cn.cyf.user.service;

import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.RoleInfo;
import cn.cyf.user.form.RoleInfoQueryForm;
import cn.cyf.user.form.RoleInfoUpdateForm;
import cn.cyf.user.result.RoleInfoResult;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * 角色service
 * @author tongyao
 */
public interface RoleInfoService extends IService<RoleInfo> {

    List<RoleInfoResult> selectRoleList(RoleInfoQueryForm form);

    ResponseData updateRoleInfo(RoleInfoUpdateForm form);

    ResponseData addRole(RoleInfoUpdateForm form);

    ResponseData deleteRole(List<String> roleIdList);
}

