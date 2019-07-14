package cn.cyf.user.service.impl;

import cn.cyf.user.entity.PermissionInfo;
import cn.cyf.user.entity.UserInfo;
import cn.cyf.user.mapper.PermissionMap;
import cn.cyf.user.result.PermissionInfoResult;
import cn.cyf.user.service.PermissionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMap, PermissionInfo> implements PermissionService {

    /**
     * 查询某用户的 角色  菜单列表   权限列表
     */
    @Override
    public UserInfo getUserPermission(String username) {
        return getUserPermissionFromDB(username);
    }

    /**
     * 从数据库查询用户权限信息
     */
    private UserInfo getUserPermissionFromDB(String username) {
        UserInfo userPermission = baseMapper.getUserPermission(username);
        if ("管理员".equals(userPermission.getRoleInfo().getRoleName())) {
            //查询所有菜单  所有权限
            List<String> menuList = baseMapper.getAllMenu();
            List<String> permissionList = baseMapper.getAllPermission();
            userPermission.setMenuList(menuList);
            userPermission.setPermissionList(permissionList);
        }
        return userPermission;
    }

    @Override
    public List<PermissionInfoResult> listAllPermission() {
        return this.baseMapper.listAllPermission();
    }
}
