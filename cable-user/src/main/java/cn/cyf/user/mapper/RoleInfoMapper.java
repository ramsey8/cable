package cn.cyf.user.mapper;

import cn.cyf.user.entity.RoleInfo;
import cn.cyf.user.form.RoleInfoUpdateForm;
import cn.cyf.user.form.RolePermissionRelationForm;
import cn.cyf.user.result.RoleInfoResult;
import cn.cyf.user.result.UserInfoResult;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RoleInfoMapper extends BaseMapper<RoleInfo> {

    List<RoleInfoResult> selectRoleList();

    /**
     * 删除角色权限映射关系
     */
    int deleteOldRolePermRelations(RoleInfoUpdateForm form);

    /**
     * 批量新增
     */
    int batchSaveRolePermissionRelations(List<RolePermissionRelationForm> formList);

    /**
     * 批量删除角色
     */
    int deleteRoles(@Param("ids") List<String> roleIdList, @Param("updateTime") Date updateTime);

    /**
     * 批量删除
     * @param roleIdList
     * @return
     */
    int deleteMultiOldRolePermRelations(@Param("ids") List<String> roleIdList, @Param("updateTime") Date updateTime);
}
