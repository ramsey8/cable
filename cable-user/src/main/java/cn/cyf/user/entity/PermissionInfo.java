package cn.cyf.user.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("sys_permission")
public class PermissionInfo {
    @TableId(type = IdType.UUID)
    private String id;
//    private String name;
    @TableField("permission_code")
    private String permissionCode;
    @TableField("permission_name")
    private String permissionName;
    @TableField("menu_code")
    private String menuCode;
    @TableField("menu_name")
    private String menuName;
//    private String desc;
//    private int isLock;
    @TableField("delete_status")
    private Integer deleteStatus;
    @TableField("required_premission")
    private Integer requiredPermission;

}
