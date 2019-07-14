package cn.cyf.user.mapper;

import cn.cyf.user.entity.PermissionInfo;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.result.PermissionInfoResult;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Set;

public interface PermissionMap extends BaseMapper<PermissionInfo> {

    /**
     * 查询用户所有权限信息
     * @param username
     * @return
     */
    UserInfo getUserPermission(String username);

    /**
     * 查询所有的菜单
     */
    List<String> getAllMenu();

    /**
     * 查询所有的权限
     */
    List<String> getAllPermission();

    List<PermissionInfoResult> listAllPermission();
}
