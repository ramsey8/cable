package cn.cyf.user.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolePermissionRelationForm {

    private String id;
    private String roleId;
    private String permissionId;
    private Date createTime;
    private Date updateTime;
    private int deleteStatus;
}
