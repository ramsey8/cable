package cn.cyf.user.service.impl;

import cn.cyf.common.ResponseData;
import cn.cyf.user.entity.RoleInfo;
import cn.cyf.user.form.RoleInfoQueryForm;
import cn.cyf.user.form.RoleInfoUpdateForm;
import cn.cyf.user.form.RolePermissionRelationForm;
import cn.cyf.user.mapper.RoleInfoMapper;
import cn.cyf.user.result.RoleInfoResult;
import cn.cyf.user.service.RoleInfoService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleInfoServiceImpl extends ServiceImpl<RoleInfoMapper, RoleInfo> implements RoleInfoService {

    @Override
    public List<RoleInfoResult> selectRoleList(RoleInfoQueryForm form) {
        return this.baseMapper.selectRoleList();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData updateRoleInfo(RoleInfoUpdateForm form) {
        form.setUpdateTime(new Date());
        this.baseMapper.deleteOldRolePermRelations(form);

        if (!CollectionUtils.isEmpty(form.getPermissions())) {
            List<RolePermissionRelationForm> rpfList =  form.getPermissions().stream().map(s -> RolePermissionRelationForm.builder().roleId(form.getRoleId())
                    .permissionId(s)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .deleteStatus(1)
                    .build()).collect(Collectors.toList());
            this.baseMapper.batchSaveRolePermissionRelations(rpfList);
        }
        RoleInfo roleInfo = new RoleInfo();
        BeanUtils.copyProperties(form, roleInfo);
        roleInfo.setId(form.getRoleId());
        this.baseMapper.updateById(roleInfo);
        return ResponseData.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData addRole(RoleInfoUpdateForm form) {
        RoleInfo roleInfo = new RoleInfo();
        BeanUtils.copyProperties(form, roleInfo);
        this.insert(roleInfo);
        if (!CollectionUtils.isEmpty(form.getPermissions())) {
            List<RolePermissionRelationForm> rpfList =  form.getPermissions().stream().map(s -> RolePermissionRelationForm.builder().roleId(roleInfo.getId())
                    .permissionId(s)
                    .createTime(new Date())
                    .updateTime(new Date())
                    .deleteStatus(1)
                    .build()).collect(Collectors.toList());
            this.baseMapper.batchSaveRolePermissionRelations(rpfList);
        }
        return ResponseData.ok();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData deleteRole(List<String> roleIdList) {

        this.baseMapper.deleteRoles(roleIdList, new Date());
        this.baseMapper.deleteMultiOldRolePermRelations(roleIdList, new Date());
        return ResponseData.ok();
    }
}
