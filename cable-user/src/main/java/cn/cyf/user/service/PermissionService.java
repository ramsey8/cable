package cn.cyf.user.service;

import cn.cyf.user.entity.PermissionInfo;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.result.PermissionInfoResult;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * @author: tongyao
 * 权限service
 */
public interface PermissionService extends IService<PermissionInfo> {
	/**
	 * 查询某用户的 角色  菜单列表   权限列表
	 */
	UserInfo getUserPermission(String username);

	List<PermissionInfoResult> listAllPermission();
}
