package cn.cyf.user.service;

import cn.cyf.user.entity.PermissionInfo;
import cn.cyf.user.entity.UserInfo;
import com.baomidou.mybatisplus.service.IService;

/**
 * @author: hxy
 * @date: 2017/10/30 13:10
 */
public interface PermissionService extends IService<PermissionInfo> {
	/**
	 * 查询某用户的 角色  菜单列表   权限列表
	 */
	UserInfo getUserPermission(String username);
}
